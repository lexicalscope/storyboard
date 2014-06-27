package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;

public interface StorySummaryCoreView {
   void outputTo(Story story, Theme theme, StorySummaryTemplate storyTemplate);
}