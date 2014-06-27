package com.lexicalscope.sb.main;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.data.UserId;
import com.lexicalscope.sb.database.TodayData;
import com.lexicalscope.sb.values.data.Relevance;

@UseStringTemplate3StatementLocator("/stories.sql.stg")
public interface StoriesDao extends TodayData {
   @SqlUpdate
   void createStoryTable();

   @SqlUpdate()
   void createRelevanceTable();

   @SqlUpdate
   void createUpvoteTable();

   @SqlUpdate
   @GetGeneratedKeys
   long insert(@BindBean Story story);

   @Override
   @SqlQuery
   Stories storyFor(@BindBean UserId userId);

   @SqlQuery
   Story story(@Bind("story") long storyId);

   @SqlUpdate
   void relevance(
         @Bind("user") UserId userId,
         @Bind("story") long storyId,
         @Bind("score") Relevance relevance);

   @SqlUpdate
   void upvote(@Bind("story") long storyId, @Bind("user") UserId userId);
}
