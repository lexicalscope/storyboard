package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;

public class DefaultTodayView implements TodayView {
   @Override public StorySummaryView storySummaryView(final Story story) {
      return new DefaultStorySummaryView(story);
   }
}
