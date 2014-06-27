package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.logging.SbLogger;

public class DefaultStoriesView implements StoriesView {
   private final TodayViews views;

   public DefaultStoriesView(final TodayViews views) {
      this.views = views;
   }

   @Override public void outputTo(final Stories stories, final Theme theme, final StorySummariesTemplate storiesTemplate) {
      for (final Story story : stories) {
         views.storySummaryView(story, theme, storiesTemplate);
      }
   }
}
