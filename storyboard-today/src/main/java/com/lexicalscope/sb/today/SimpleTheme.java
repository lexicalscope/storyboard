package com.lexicalscope.sb.today;


public class SimpleTheme implements Theme {
   @Override public TodayTemplate todayTemplate() {
      return new BeanTodayTemplate();
   }

   @Override public StorySummaryTemplate storySummaryTemplate() {
      return new BeanStorySummaryTemplate();
   }

   @Override public StoryHighlightTemplate storyHighlightTemplate() {
      return new BeanStoryHighlightTemplate();
   }
}
