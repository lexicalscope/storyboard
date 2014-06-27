package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.logging.SbLogger;

public class DefaultStorySummaryView implements StorySummaryView {
   private final Story story;
   private final SbLogger logger;
   private final StorySummaryPartialView partialView;

   public DefaultStorySummaryView(final SbLogger logger, final Story story, final StorySummaryPartialView partialView) {
      this.logger = logger;
      this.story = story;
      this.partialView = partialView;
   }

   @Override public void outputTo(final Theme theme, final StorySummariesTemplate storiesTemplate) {
      logger.debug("viewing story %s", story.id());

      final StorySummaryTemplate storyTemplate = theme.storySummaryTemplate();
      partialView.outputTo(theme, storyTemplate);
      storiesTemplate.addStory(storyTemplate);
   }
}
