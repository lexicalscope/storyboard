package com.lexicalscope.sb.today;

import static com.lexicalscope.sb.data.Stories.stories;
import static com.lexicalscope.sb.data.Story.story;
import static com.lexicalscope.sb.today.TestSortingStoriesView.AddHighlightAction.addHighlight;
import static com.lexicalscope.sb.today.TestSortingStoriesView.AddStoryAction.addStory;

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

   @Mock private StoryHighlightTemplate bobHighlight;
   @Mock private StoryHighlightTemplate carolHighlight;
   @Mock private StoryHighlightTemplate daveHighlight;

   @Auto private Sequence outputSequence;

   @Test public void storiesAreSortedByRelevance() {
      final Story bobsStory = story().id(1).relevance(3).upvoteCount(6).build();
      final Story carolsStory = story().id(2).relevance(7).upvoteCount(7).build();
      final Story davesStory = story().id(3).relevance(1).upvoteCount(8).build();

      final Stories stories = stories().with(bobsStory, carolsStory, davesStory).make();
      context.checking(new StoryExpectations(){{
         storyIsViewed(bobsStory); will(addStory(bobTemplate));
         storyIsViewed(carolsStory); will(addStory(carolTemplate));
         storyIsViewed(davesStory); will(addStory(daveTemplate));

         storyIsHighighted(bobsStory); will(addHighlight(bobHighlight));
         storyIsHighighted(carolsStory); will(addHighlight(carolHighlight));
         storyIsHighighted(davesStory); will(addHighlight(daveHighlight));

         oneOf(storiesTemplate).addStory(carolTemplate); inSequence(outputSequence);
         oneOf(storiesTemplate).addStory(bobTemplate); inSequence(outputSequence);
         oneOf(storiesTemplate).addStory(daveTemplate); inSequence(outputSequence);

         oneOf(storiesTemplate).addHighlight(daveHighlight); inSequence(outputSequence);
         oneOf(storiesTemplate).addHighlight(carolHighlight); inSequence(outputSequence);
         oneOf(storiesTemplate).addHighlight(bobHighlight); inSequence(outputSequence);
      }});
      new SortingStoriesView(todayViews).outputTo(stories, theme, storiesTemplate);
   }

   public class StoryExpectations extends Expectations {
      public void storyIsViewed(final Story story) {
         oneOf(todayViews).storySummaryView(with(story), with(theme), with(any(StorySummariesTemplate.class)));
      }

      public void storyIsHighighted(final Story story) {
         oneOf(todayViews).storyHighlight(with(story), with(theme), with(any(StorySummariesTemplate.class)));
      }
   }

   public static final class AddStoryAction implements org.jmock.api.Action {
      private final StorySummaryTemplate story;

      public AddStoryAction(final StorySummaryTemplate story) {
         this.story = story;
      }

      @Override public void describeTo(final Description description) {
         description.appendText("add story ").appendValue(story);
      }

      @Override public Object invoke(final Invocation invocation) throws Throwable {
         final StorySummariesTemplate storySummariesTemplate = (StorySummariesTemplate)invocation.getParameter(2);
         storySummariesTemplate.addStory(story);
         return null;
      }

      public static Action addStory(final StorySummaryTemplate story) {
         return new AddStoryAction(story);
      }
   }

   public static final class AddHighlightAction implements org.jmock.api.Action {
      private final StoryHighlightTemplate story;

      public AddHighlightAction(final StoryHighlightTemplate story) {
         this.story = story;
      }

      @Override public void describeTo(final Description description) {
         description.appendText("add story highlight ").appendValue(story);
      }

      @Override public Object invoke(final Invocation invocation) throws Throwable {
         final StorySummariesTemplate storySummariesTemplate = (StorySummariesTemplate)invocation.getParameter(2);
         storySummariesTemplate.addHighlight(story);
         return null;
      }

      public static Action addHighlight(final StoryHighlightTemplate story) {
         return new AddHighlightAction(story);
      }
   }
}
