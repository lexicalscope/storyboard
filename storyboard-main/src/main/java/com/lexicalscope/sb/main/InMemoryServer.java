package com.lexicalscope.sb.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;

import com.lexicalscope.sb.app.Main;
import com.lexicalscope.sb.dispatch.Controller;

public final class InMemoryServer implements AutoCloseable {
   private Server jetty;
   private JdbcConnectionPool ds;
   private DBI dbi;

   public static void main(final String[] args) throws Exception {
      try(final InMemoryServer inMemoryServer = new InMemoryServer()) {
         inMemoryServer.start();
         inMemoryServer.jetty.join();
      }
   }

   public void start() throws Exception {
      ds = JdbcConnectionPool.create("jdbc:h2:mem:test",
            "username",
            "password");
      dbi = new DBI(ds);
      dbi.registerArgumentFactory(new TitleArgumentFactory());
      dbi.registerArgumentFactory(new SummaryArgumentFactory());
      dbi.registerArgumentFactory(new RelevanceArgumentFactory());
      dbi.registerArgumentFactory(new UserIdArgumentFactory());
      dbi.registerContainerFactory(new StoryContainerFactory());
      dbi.registerMapper(new StoryMapper());
      dbi.registerMapper(new UserMapper());
      users().createUserTable();
      story().createStoryTable();
      story().createRelevanceTable();
      story().createUpvoteTable();

      final SimpleMustacheTheme theme = new SimpleMustacheTheme();
      final Controller controller = new Main().createController(new JdbiDb(dbi), theme);

      jetty = new Server(8080);
      jetty.setHandler(new AbstractHandler() {
         @Override public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
            controller.handle(new JettyWebRequest(target, baseRequest, request), new ServletWebResponse(response, theme));
         }
      });
      jetty.start();
   }

   public UserDao users() {
      return dbi.onDemand(UserDao.class);
   }

   public StoriesDao story() {
      return dbi.onDemand(StoriesDao.class);
   }

   public void dropAll() {
      dbi.onDemand(DropDao.class);
   }

   @Override public void close() throws Exception {
      if (jetty != null) { jetty.stop(); }
      if (ds != null) { ds.dispose(); }
   }

   public void startConsole() {
      try(Connection connection = ds.getConnection()) {
         org.h2.tools.Server.startWebServer(connection);
      } catch (final SQLException e) {
         throw new RuntimeException(e);
      }
   }
}