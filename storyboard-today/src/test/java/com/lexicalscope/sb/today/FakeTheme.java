package com.lexicalscope.sb.today;


public class FakeTheme implements Theme {
   @Override public TodayTemplate todayTemplate() {
      return new BeanTodayTemplate();
   }

   @Override public StorySummaryTemplate storySummaryTemplate() {
      return new BeanStorySummaryTemplate();
   }
}
