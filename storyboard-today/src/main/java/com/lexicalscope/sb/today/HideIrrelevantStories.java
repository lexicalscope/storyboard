package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;

public class HideIrrelevantStories implements StorySummaryView {
   private final Story story;
   private final StorySummaryView delegate;

   public HideIrrelevantStories(final Story story, final StorySummaryView delegate) {
      this.story = story;
      this.delegate = delegate;
   }

   @Override public void outputTo(final Theme theme, final TodayTemplate todayTemplate) {
      if(story.relevance().greaterEqual(10)) {
         delegate.outputTo(theme, todayTemplate);
      }
   }
}