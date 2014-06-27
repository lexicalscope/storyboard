package com.lexicalscope.sb.today;

import com.lexicalscope.sb.http.Template;

public interface TodayTemplate extends Template, StorySummariesTemplate {
   void userName(String name);
}
