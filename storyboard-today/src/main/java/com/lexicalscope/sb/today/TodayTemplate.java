package com.lexicalscope.sb.today;

import com.lexicalscope.sb.http.Template;

public interface TodayTemplate extends Template {
   void userName(String name);
   void addStory(StorySummaryTemplate storyTemplate);
}
