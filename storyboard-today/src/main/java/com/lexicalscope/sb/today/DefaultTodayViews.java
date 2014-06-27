package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.logging.SbLogger;

public class DefaultTodayViews implements TodayViews {
   private final SbLogger logger;

   public DefaultTodayViews(final SbLogger logger) {
      this.logger = logger;
   }

   @Override public StorySummaryView storySummaryView(final Story story, final Theme theme, final StorySummariesTemplate storiesTemplate) {
      final HideIrrelevantStories view = new HideIrrelevantStories(story,
            new DefaultStorySummaryView(logger, story,
                  new CompositeStorySummaryPartialView(
                        new StorySummaryMainView(story),
                        new StorySummaryBadgeView(story))));
      view.outputTo(theme, storiesTemplate);
      return view;
   }

   @Override public StoriesView todayView(final Stories stories, final Theme theme, final StorySummariesTemplate storiesTemplate) {
      final StoriesView view = new DefaultStoriesView(this);
      view.outputTo(stories, theme, storiesTemplate);
      return view;
   }
}
