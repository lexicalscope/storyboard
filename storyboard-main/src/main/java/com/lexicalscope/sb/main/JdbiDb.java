package com.lexicalscope.sb.main;

import org.skife.jdbi.v2.DBI;

import com.lexicalscope.sb.database.StoryDatabase;
import com.lexicalscope.sb.database.TodayData;
import com.lexicalscope.sb.database.UserData;

public class JdbiDb implements StoryDatabase {
   private final DBI dbi;

   public JdbiDb(final DBI dbi) {
      this.dbi = dbi;
   }

   @Override public TodayData todayData() {
      return dbi.onDemand(StoriesDao.class);
   }

   @Override public UserData userData() {
      return dbi.onDemand(UserDao.class);
   }
}
