package com.lexicalscope.sb.database;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.UserId;

public interface TodayData {
   Stories storyFor(UserId username);
}
