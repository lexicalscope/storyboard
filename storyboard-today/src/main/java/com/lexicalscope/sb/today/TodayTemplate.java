package com.lexicalscope.sb.today;

import com.lexicalscope.sb.http.Template;

public interface TodayTemplate extends Template {
   TodayTemplate userName(String name);
   TodayTemplate addStory(StorySummaryTemplate storyTemplate);
}
