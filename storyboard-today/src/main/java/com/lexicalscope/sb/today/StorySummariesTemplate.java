package com.lexicalscope.sb.today;

import com.lexicalscope.sb.http.Template;

public interface StorySummariesTemplate extends Template {
   void addStory(StorySummaryTemplate storyTemplate);
}