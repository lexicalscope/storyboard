package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;

public interface TodayViews {
   void todayView(Stories stories, Theme theme, StorySummariesTemplate storiesTemplate);
   void storySummaryView(Story story, Theme theme, StorySummariesTemplate storiesTemplate);
   void storyHighlight(Story story, Theme theme, StorySummariesTemplate storiesTemplate);
}