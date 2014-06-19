package com.lexicalscope.sb.database.fake;

import com.lexicalscope.sb.database.StoryDatabase;
import com.lexicalscope.sb.database.TodayData;
import com.lexicalscope.sb.database.UserData;

public class FakeStoriesDatabase implements StoryDatabase {
   private TodayData todayData;
   private UserData userData;

   public void todayData(final TodayData todayData) {
      this.todayData = todayData;
   }

   @Override public TodayData todayData() {
      return todayData;
   }

   @Override public UserData userData() {
      return userData;
   }

   public void userData(final UserData userData) {
      this.userData = userData;
   }
}
