package com.lexicalscope.sb.main;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.data.Story.StoryBuilder;
import com.lexicalscope.sb.data.User;
import com.lexicalscope.sb.data.UserId;
import com.lexicalscope.sb.values.data.Relevance;

@RunWith(Suite.class)
@SuiteClasses({ TestTodayPage.class, TestStoriesDao.class })
public class TestServerSuite {
   private static ThreadLocal<InMemoryServer> server = new ThreadLocal<InMemoryServer>();
   private static ThreadLocal<Boolean> inSuite = new ThreadLocal<Boolean>(){
      @Override protected Boolean initialValue() { return false; };
   };

   @BeforeClass public static void setUpClass() throws Exception {
      inSuite.set(true);
      startServer();
   }

   public static void setupTest() throws Exception {
      if(inSuite.get()) {
         return;
      }
     startServer();
   }

   private static void startServer() throws Exception {
      if(server.get() == null)
      {
         server.set(new InMemoryServer());
         server.get().start();
      }
   }

   @AfterClass public static void tearDownClass() throws Exception {
      try {
         server.get().close();
      } finally {
         inSuite.remove();
         server.remove();
      }
   }

   public static void tearDownTest() throws Exception {
      if(inSuite.get()) {
         return;
      }
      tearDownClass();
   }

   public static long insertUser(final User user) {
      return server.get().users().insert(user);
   }

   public static long insertStory(final Story story) {
      return stories().insert(story);
   }

   public static void setRelevance(final long userId, final long storyId, final int relevance)
   {
      stories().relevance(new UserId(userId), storyId, new Relevance(relevance));
   }

   public static void upvote(final long storyId, final long userId)
   {
      stories().upvote(storyId, new UserId(userId));
   }

   public static StoriesDao stories() {
      return server.get().story();
   }

   public static long insertStory(final StoryBuilder story) {
      return insertStory(story.build());
   }

   public static void startConsole() {
      server.get().startConsole();
   }

   public static void dropAll() {
      server.get().dropAll();
   }
}
