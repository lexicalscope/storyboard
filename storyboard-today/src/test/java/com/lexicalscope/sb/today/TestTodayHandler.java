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
import com.lexicalscope.sb.database.StoryDatabase;
import com.lexicalscope.sb.database.fake.FakeStoriesDatabase;
import com.lexicalscope.sb.http.WebRequest;
import com.lexicalscope.sb.http.fake.FakeWebRequest;
import com.lexicalscope.sb.http.fake.FakeWebResponse;

public class TestTodayHandler {
   private final FakeStoriesDatabase db = new FakeStoriesDatabase();
   private final FakeWebRequest request = new FakeWebRequest();

   private final FakeUserData userData = new FakeUserData();
   private final FakeTodayData todayData = new FakeTodayData();

   private UserId userId;

   private final StoryBuilder bobsStory = story().author("Bob Builder").title("Build Things").summary("Build All The Things").relevance(10);
   private final StoryBuilder carolsStory = story().author("Carol Singer").title("Sing Things").summary("Sing All The Things").relevance(3);
   private final StoryBuilder davesStory = story().author("Dave Driver").title("Drive Things").summary("Drive All The Things").relevance(10);
   private final Matcher<BeanTodayTemplate> isBobsStory = showsStoryFrom("Bob Builder", titleIs("Build Things"), summaryIs("Build All The Things"), relevance(10));
   private final Matcher<BeanTodayTemplate> isCarolsStory = showsStoryFrom("Carol Singer", titleIs("Sing Things"), summaryIs("Sing All The Things"), relevance(3));
   private final Matcher<BeanTodayTemplate> isDavesStory = showsStoryFrom("Dave Driver", titleIs("Drive Things"), summaryIs("Drive All The Things"), relevance(10));

   public TestTodayHandler() {
      db.userData(userData.user(user().name("Alice Acrobat").make()));
      db.todayData(todayData.storyFor(userId, stories()
            .with(bobsStory).with(carolsStory).with(davesStory).make()));
   }

   @Test public void storyAreShownForUser() {
      final FakeWebResponse response = runTodayHandler(db, request);

      final BeanTodayTemplate todayTemplate = (BeanTodayTemplate) response.content();
      assertThat(response, statusIs(200));
      assertThat(todayTemplate, showsUser("Alice Acrobat"));
      assertThat(todayTemplate, allOf(isBobsStory, isCarolsStory, isDavesStory));
   }

   // entry point for test generation
   public static FakeWebResponse runTodayHandler(final StoryDatabase db, final WebRequest request)
   {
      final FakeWebResponse response = new FakeWebResponse();
      new TodayHandler(db, new FakeTheme(), new DefaultTodayView()).get(request, response);
      return response;
   }
}