package com.lexicalscope.sb.today;

import static com.google.common.collect.ImmutableSortedMap.copyOf;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableCollection;
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
      for (final StorySummaryTemplate storyTemplate : sortByRelevance(collateStories(stories, theme))) {
         storiesTemplate.addStory(storyTemplate);
      }
   }

   private Map<Story, StorySummaryTemplate> collateStories(final Stories stories, final Theme theme) {
      final Map<Story, StorySummaryTemplate> storyTemplates = new HashMap<>();
      for (final Story story : stories) {
         views.storySummaryView(story, theme, new StorySummariesTemplate(){
            @Override public void addStory(final StorySummaryTemplate storyTemplate) {
               storyTemplates.put(story, storyTemplate);
            }});
      }
      return storyTemplates;
   }

   private ImmutableCollection<StorySummaryTemplate> sortByRelevance(final Map<Story, StorySummaryTemplate> storyTemplates) {
      return copyOf(storyTemplates, byRelevance.compound(byId)).values();
   }

   private static final Ordering<Story> byRelevance = new Ordering<Story>() {
      @Override public int compare(final Story left, final Story right) {
         return Ints.compare(right.relevance().score(), left.relevance().score());
      }
   };
   private static final Ordering<Story> byId = new Ordering<Story>() {
      @Override public int compare(final Story left, final Story right) {
         return Longs.compare(right.id(), left.id());
      }
   };
}