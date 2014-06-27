package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.logging.SbLogger;

public class DefaultStorySummaryView implements StorySummaryView {
   private final Story story;
   private final SbLogger logger;
   private final StorySummaryCoreView coreView;

   public DefaultStorySummaryView(final SbLogger logger, final Story story, final StorySummaryCoreView coreView) {
      this.logger = logger;
      this.story = story;
      this.coreView = coreView;
   }

   @Override public void outputTo(final Theme theme, final TodayTemplate todayTemplate) {
      logger.debug("viewing story %s", story.id());

      final StorySummaryTemplate storyTemplate = theme.storySummaryTemplate();
      coreView.outputTo(story, theme, storyTemplate);
      todayTemplate.addStory(storyTemplate);
   }
}
