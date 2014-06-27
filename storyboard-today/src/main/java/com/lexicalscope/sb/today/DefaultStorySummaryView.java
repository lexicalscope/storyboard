package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.logging.SbLogger;

public class DefaultStorySummaryView implements StorySummaryView {
   private final Story story;
   private final SbLogger logger;

   public DefaultStorySummaryView(final SbLogger logger, final Story story) {
      this.logger = logger;
      this.story = story;
   }

   @Override public void outputTo(final Theme theme, final TodayTemplate todayTemplate) {
      logger.debug("viewing story %s", story.id());

      final StorySummaryTemplate storyTemplate = theme.storySummaryTemplate();
      storyTemplate.id(story.id());
      storyTemplate.title(story.title());
      storyTemplate.author(story.author());
      storyTemplate.summary(story.summary());
      storyTemplate.relevance(story.relevance());
      todayTemplate.addStory(storyTemplate);
   }
}
