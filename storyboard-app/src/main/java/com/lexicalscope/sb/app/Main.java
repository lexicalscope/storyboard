package com.lexicalscope.sb.app;

import com.lexicalscope.sb.database.StoryDatabase;
import com.lexicalscope.sb.dispatch.Controller;
import com.lexicalscope.sb.today.DefaultTodayView;
import com.lexicalscope.sb.today.Theme;
import com.lexicalscope.sb.today.TodayHandler;

public class Main {
   public Controller createController(final StoryDatabase db, final Theme theme) {
      final Controller result = new Controller();
      result.register("/today", new TodayHandler(db, theme, new DefaultTodayView()));
      return result;
   }
}
