package com.lexicalscope.sb.main;

import static com.lexicalscope.sb.data.Story.*;
import static com.lexicalscope.sb.main.TestServerSuite.*;
import static com.lexicalscope.sb.values.data.Relevance.hasRelevance;
import static com.lexicalscope.sb.values.data.UpvoteCount.hasUpvoteCount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.data.User;

public class TestStoriesDao extends BaseTestServer  {
   private long storyId;
   private long user1;

   @Before public void prepare() {
      user1 = insertUser(new User(null, "Alice"));
      final long user2 = insertUser(new User(null, "Bob"));

      storyId = insertStory(story().authorId(user1).title("My story").summary("It is a great story."));
      setRelevance(user1, storyId, 14);
      upvote(storyId, user1);
      upvote(storyId, user2);
   }

   @Test public void storyUpvotesAreCounted() {
      final Story story = stories().story(storyId);
      assertThat(story, theTitle(hasToString("My story")));
      assertThat(story, theScore(hasRelevance(equalTo(0))));
      assertThat(story, theUpvotes(hasUpvoteCount(equalTo(2))));
   }
}
