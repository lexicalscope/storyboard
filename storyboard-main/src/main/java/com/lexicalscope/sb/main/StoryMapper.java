package com.lexicalscope.sb.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.values.data.Relevance;
import com.lexicalscope.sb.values.data.Summary;
import com.lexicalscope.sb.values.data.Title;
import com.lexicalscope.sb.values.data.UpvoteCount;
import com.lexicalscope.sb.values.user.Name;

public class StoryMapper implements ResultSetMapper<Story> {
   @Override public Story map(final int index, final ResultSet r, final StatementContext ctx) throws SQLException {
      return new Story(
               r.getLong("id"),
               new Name(r.getString("authorname")),
               r.getLong("author"),
               new Title(r.getString("title")),
               new Summary(r.getString("summary")),
               new Relevance(r.getInt("score")),
               new UpvoteCount(r.getInt("upvotes"))
               );
   }
}
