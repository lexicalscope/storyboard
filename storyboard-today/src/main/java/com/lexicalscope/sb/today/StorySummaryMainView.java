package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;

public class StorySummaryMainView implements StorySummaryPartialView {
   private final Story story;

   public StorySummaryMainView(final Story story) {
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