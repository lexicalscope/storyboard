package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.logging.SbLogger;

public class DefaultTodayViews implements TodayViews {
   private final SbLogger logger;

   public DefaultTodayViews(final SbLogger logger) {
      this.logger = logger;
   }

   @Override public void storySummaryView(final Story story, final Theme theme, final StorySummariesTemplate storiesTemplate) {
      new HideIrrelevantStories(story,
            new DefaultStorySummaryView(logger, story,
                  new CompositeStorySummaryPartialView(
                        new StorySummaryMainView(story),
                        new StorySummaryBadgeView(story)))).outputTo(theme, storiesTemplate);
   }

   @Override public void todayView(final Stories stories, final Theme theme, final StorySummariesTemplate storiesTemplate) {
      new DefaultStoriesView(this).outputTo(stories, theme, storiesTemplate);
   }
}
