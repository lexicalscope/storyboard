package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Stories;

public interface TodayView {
   void outputTo(Stories stories, Theme theme, TodayTemplate todayTemplate);
}
