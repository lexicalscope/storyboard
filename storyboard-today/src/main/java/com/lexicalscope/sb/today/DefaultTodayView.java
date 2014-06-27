package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.logging.SbLogger;

public class DefaultTodayView implements TodayView {
   private final SbLogger logger;

   public DefaultTodayView(final SbLogger logger) {
      this.logger = logger;
   }

   @Override public StorySummaryView storySummaryView(final Story story) {
      return new HideIrrelevantStories(story,
            new DefaultStorySummaryView(logger, story,
                  new CompositeStorySummaryCoreView(
                        new DefaultStorySummaryCoreView(story),
                        new StorySummaryBadgeView(story))));
   }
}
