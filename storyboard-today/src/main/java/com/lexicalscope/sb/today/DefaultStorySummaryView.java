package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;

public class DefaultStorySummaryView implements StorySummaryView {
   private final Story story;

   public DefaultStorySummaryView(final Story story) {
      this.story = story;
   }

   @Override public void outputTo(final Theme theme, final TodayTemplate todayTemplate) {
      final StorySummaryTemplate storyTemplate = theme.storySummaryTemplate();
      storyTemplate.id(story.id());
      storyTemplate.title(story.title());
      storyTemplate.author(story.author());
      storyTemplate.summary(story.summary());
      storyTemplate.relevance(story.relevance());
      todayTemplate.addStory(storyTemplate);
   }
}
