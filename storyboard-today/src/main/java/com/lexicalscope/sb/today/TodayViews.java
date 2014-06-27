package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;

public interface TodayViews {
   TodayView todayView(Stories stories, Theme theme, TodayTemplate todayTemplate);
   StorySummaryView storySummaryView(Story story, Theme theme, TodayTemplate todayTemplate);
}