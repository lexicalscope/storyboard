package com.lexicalscope.sb.today;

import java.util.List;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;

public class SortingStoriesView implements StoriesView {
   private final TodayViews views;

   public SortingStoriesView(final TodayViews views) {
      this.views = views;
   }

   @Override public void outputTo(final Stories stories, final Theme theme, final StorySummariesTemplate storiesTemplate) {
      final List<Story> sortedList = byRelevance.compound(byId).sortedCopy(stories);
      final Stories sortedStories = new Stories(sortedList);

      final List<Story> topStories = byUpvote.compound(byId)
               .sortedCopy(sortedList)
               .subList(0, Math.min(3, sortedList.size()));

      for (final Story story : sortedStories) {
         views.storySummaryView(story, theme, storiesTemplate);
      }

      for (final Story story : topStories) {
         views.storyHighlight(story, theme, storiesTemplate);
      }
   }

   private static final Ordering<Story> byRelevance = new Ordering<Story>() {
      @Override public int compare(final Story left, final Story right) {
         return Ints.compare(right.relevance().score(), left.relevance().score());
      }
   };
   private static final Ordering<Story> byUpvote = new Ordering<Story>() {
      @Override public int compare(final Story left, final Story right) {
         return Ints.compare(right.upvoteCount().count(), left.upvoteCount().count());
      }
   };
   private static final Ordering<Story> byId = new Ordering<Story>() {
      @Override public int compare(final Story left, final Story right) {
         return Longs.compare(right.id(), left.id());
      }
   };
}