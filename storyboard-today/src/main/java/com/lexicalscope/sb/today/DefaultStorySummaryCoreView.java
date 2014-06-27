package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;

public class DefaultStorySummaryCoreView implements StorySummaryCoreView {
   private final Story story;

   public DefaultStorySummaryCoreView(final Story story) {
      this.story = story;
   }

   @Override public void outputTo(final Theme theme, final StorySummaryTemplate storyTemplate) {
      storyTemplate.id(story.id());
      storyTemplate.title(story.title());
      storyTemplate.author(story.author());
      storyTemplate.summary(story.summary());
      storyTemplate.relevance(story.relevance());
   }
}