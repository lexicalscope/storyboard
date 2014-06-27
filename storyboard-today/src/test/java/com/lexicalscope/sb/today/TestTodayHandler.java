package com.lexicalscope.sb.today;

import static com.lexicalscope.MatchersAdditional.allOf;
import static com.lexicalscope.sb.data.Stories.stories;
import static com.lexicalscope.sb.data.Story.story;
import static com.lexicalscope.sb.data.User.user;
import static com.lexicalscope.sb.http.fake.FakeWebResponse.statusIs;
import static com.lexicalscope.sb.today.BeanStorySummaryTemplate.*;
import static com.lexicalscope.sb.today.BeanTodayTemplate.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matcher;
import org.junit.Test;

import com.lexicalscope.sb.data.Story.StoryBuilder;
import com.lexicalscope.sb.data.UserId;
import com.lexicalscope.sb.database.fake.FakeStoriesDatabase;
import com.lexicalscope.sb.http.fake.FakeWebRequest;
import com.lexicalscope.sb.http.fake.FakeWebResponse;

public class TestTodayHandler {
   private final FakeStoriesDatabase db = new FakeStoriesDatabase();
   private final FakeWebRequest request = new FakeWebRequest();

   private final FakeUserData userData = new FakeUserData();
   private final FakeTodayData todayData = new FakeTodayData();

   private UserId userId;

   private final StoryBuilder bobsStory = story().id(1).author("Bob Builder").title("Build Things").summary("Build All The Things").relevance(10);
   private final StoryBuilder carolsStory = story().id(2).author("Carol Singer").title("Sing Things").summary("Sing All The Things").relevance(10);
   private final StoryBuilder davesStory = story().id(3).author("Dave Driver").title("Drive Things").summary("Drive All The Things").relevance(10);
   private final Matcher<BeanTodayTemplate> isBobsStory = showsStoryFrom("Bob Builder", titleIs("Build Things"), summaryIs("Build All The Things"), relevance(10));
   private final Matcher<BeanTodayTemplate> isCarolsStory = showsStoryFrom("Carol Singer", titleIs("Sing Things"), summaryIs("Sing All The Things"), relevance(10));
   private final Matcher<BeanTodayTemplate> isDavesStory = showsStoryFrom("Dave Driver", titleIs("Drive Things"), summaryIs("Drive All The Things"), relevance(10));

   @Test public void responseIsOK() {
      assertThat(runTest(), statusIs(200));
   }

   @Test public void userIsShown() {
      assertThat((BeanTodayTemplate) runTest().content(),
                 showsUser("Alice Acrobat"));
   }

   @Test public void storiesAreShownForUser() {
      assertThat((BeanTodayTemplate) runTest().content(),
                 allOf(isBobsStory, isCarolsStory, isDavesStory));
   }

   @Test public void relevantStoriesAreShownForUser() {
      carolsStory.relevance(3);

      assertThat((BeanTodayTemplate) runTest().content(),
                 allOf(isBobsStory, isDavesStory));
   }

   private FakeWebResponse runTest() {
      db.userData(userData.user(user().name("Alice Acrobat").make()));
      db.todayData(todayData.storyFor(userId, stories()
            .with(bobsStory).with(carolsStory).with(davesStory).make()));

      return new TodayTestRig().runTodayHandler(db, request);
   }
}
