package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;

public interface TodayViews {
   StoriesView todayView(Stories stories, Theme theme, StorySummariesTemplate storiesTemplate);
   StorySummaryView storySummaryView(Story story, Theme theme, StorySummariesTemplate storiesTemplate);
}