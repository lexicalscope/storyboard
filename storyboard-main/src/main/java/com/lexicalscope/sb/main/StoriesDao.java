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
   @SqlUpdate("create table story (id identity primary key, title varchar(100), summary varchar(200), author BIGINT, foreign key (author) references user(id))")
   void createStoryTable();

   @SqlUpdate("create table relevance (user bigint, story bigint, score int, foreign key (user) references user(id), foreign key (story) references story(id), primary key (user, story))")
   void createRelevanceTable();

   @SqlUpdate("create table upvote (story bigint, user bigint, foreign key (user) references user(id), foreign key (story) references story(id), primary key (user, story))")
   void createUpvoteTable();

   @SqlUpdate("insert into story (title, summary, author) values (:title, :summary, :authorId)")
   @GetGeneratedKeys
   long insert(@BindBean Story story);

   @Override
   @SqlQuery
   Stories storyFor(@BindBean UserId userId);

   @SqlQuery()
   Story story(@Bind("story") long storyId);

   @SqlUpdate("merge into relevance (user, story, score) values (:user, :story, :score)")
   void relevance(
         @Bind("user") UserId userId,
         @Bind("story") long storyId,
         @Bind("score") Relevance relevance);

   @SqlUpdate("merge into upvote (story, user) values (:story, :user)")
   void upvote(@Bind("story") long storyId, @Bind("user") UserId userId);
}
