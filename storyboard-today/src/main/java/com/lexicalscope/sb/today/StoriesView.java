package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Stories;

public interface StoriesView {
   void outputTo(Stories stories, Theme theme, StorySummariesTemplate storiesTemplate);
}
