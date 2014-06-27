package com.lexicalscope.sb.main;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.data.UserId;
import com.lexicalscope.sb.database.TodayData;
import com.lexicalscope.sb.values.data.Relevance;

public interface StoriesDao extends TodayData {
   @SqlUpdate("create table story (id identity primary key, title varchar(100), summary varchar(200), author BIGINT, foreign key (author) references user(id))")
   void createStoryTable();

   @SqlUpdate("create table relevance (user bigint, story bigint, score int, foreign key (user) references user(id), foreign key (story) references story(id), primary key (user, story))")
   void createRelevanceTable();

   @SqlUpdate("insert into story (title, summary, author) values (:title, :summary, :authorId)")
   @GetGeneratedKeys
   long insert(@BindBean Story story);

   @Override
   @SqlQuery("select * from story join (select * from relevance where relevance.user=:id) r on r.story=story.id join user on story.author = user.id")
   Stories storyFor(@BindBean UserId userId);

   @SqlUpdate("merge into relevance (user, story, score) values (:user, :story, :score)")
   void relevance(
         @Bind("user") UserId userId,
         @Bind("story") long storyId,
         @Bind("score") Relevance relevance);
}
