package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.UserId;
import com.lexicalscope.sb.database.TodayData;

public class FakeTodayData implements TodayData {
   private Stories story;

   @Override public Stories storyFor(final UserId username) {
      return story;
   }

   public FakeTodayData storyFor(final UserId username, final Stories story) {
      this.story = story;
      return this;
   }
}
