package com.lexicalscope.sb.today;

import static com.lexicalscope.sb.data.Stories.stories;
import static com.lexicalscope.sb.data.Story.story;
import static com.lexicalscope.sb.today.TestSortingStoriesView.CallbackAction.addStory;

import org.hamcrest.Description;
import org.jmock.Expectations;
import org.jmock.Sequence;
import org.jmock.api.Action;
import org.jmock.api.Invocation;
import org.jmock.auto.Auto;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;

public class TestSortingStoriesView {
   @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
   @Mock private TodayViews todayViews;
   @Mock private Theme theme;
   @Mock private StorySummariesTemplate storiesTemplate;

   @Mock private StorySummaryTemplate bobTemplate;
   @Mock private StorySummaryTemplate carolTemplate;
   @Mock private StorySummaryTemplate daveTemplate;

   @Auto private Sequence outputSequence;

   @Test public void storiesAreSortedByRelevance() {
      final Story bobsStory = story().id(1).relevance(3).build();
      final Story carolsStory = story().id(2).relevance(7).build();
      final Story davesStory = story().id(3).relevance(1).build();

      final Stories stories = stories().with(bobsStory, carolsStory, davesStory).make();
      context.checking(new StoryExpectations(){{
         storyIsViewed(bobsStory); will(addStory(bobTemplate));
         storyIsViewed(carolsStory); will(addStory(carolTemplate));
         storyIsViewed(davesStory); will(addStory(daveTemplate));

         oneOf(storiesTemplate).addStory(carolTemplate); inSequence(outputSequence);
         oneOf(storiesTemplate).addStory(bobTemplate); inSequence(outputSequence);
         oneOf(storiesTemplate).addStory(daveTemplate); inSequence(outputSequence);
      }});
      new SortingStoriesView(todayViews).outputTo(stories, theme, storiesTemplate);
   }

   public class StoryExpectations extends Expectations {
      public void storyIsViewed(final Story bobsStory) {
         oneOf(todayViews).storySummaryView(with(bobsStory), with(theme), with(any(StorySummariesTemplate.class)));
      }
   }

   public static final class CallbackAction implements org.jmock.api.Action {
      private final StorySummaryTemplate story;

      public CallbackAction(final StorySummaryTemplate story) {
         this.story = story;
      }

      @Override public void describeTo(final Description description) {
         description.appendText("add story ").appendValue(story);
      }

      @Override public Object invoke(final Invocation invocation) throws Throwable {
         ((StorySummariesTemplate)invocation.getParameter(2)).addStory(story);
         return null;
      }

      public static Action addStory(final StorySummaryTemplate story) {
         return new CallbackAction(story);
      }
   }
}
