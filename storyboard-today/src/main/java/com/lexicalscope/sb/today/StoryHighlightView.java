package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;

public class StoryHighlightView implements StorySummaryView  {
   private final Story story;

   public StoryHighlightView(final Story story) {
      this.story = story;
   }

   @Override public void outputTo(final Theme theme, final StorySummariesTemplate storiesTemplate) {
      final StoryHighlightTemplate storyTemplate = theme.storyHighlightTemplate();
      storyTemplate.id(story.id());
      storyTemplate.title(story.title());
      storiesTemplate.addHighlight(storyTemplate);
   }
}
