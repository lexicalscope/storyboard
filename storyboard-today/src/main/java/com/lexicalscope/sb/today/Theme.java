package com.lexicalscope.sb.today;

import com.lexicalscope.sb.Pure;

public interface Theme {
   @Pure TodayTemplate todayTemplate();
   @Pure StorySummaryTemplate storySummaryTemplate();
   @Pure StoryHighlightTemplate storyHighlightTemplate();
}
