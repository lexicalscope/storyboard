package com.lexicalscope.sb.main;

import static com.lexicalscope.sb.data.Story.story;
import static com.lexicalscope.sb.main.TestServerSuite.*;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lexicalscope.sb.data.User;

public class TestTodayPage extends BaseTestServer {
   private long story;

   @Before public void prepare() {
      setBaseUrl("http://localhost:8080/");

      final long user = insertUser(new User("Alice"));
      getTestContext().addCookie("userid", ""+user, "localhost");

      story = insertStory(story().authorId(user).title("My story").summary("It is a great story."));
      setRelevance(user, story, 14);
   }

   @After public void cleanup() {
      dropAll();
   }

   @Test public void userNameIsInTitle() {
      beginAt("/today");
      assertTitleEquals("Today - Alice");
   }

   @Test public void storySummaryIsShown() {
      beginAt("/today");
      assertTextInElement("story-title-" + story, "My story");
   }
}
