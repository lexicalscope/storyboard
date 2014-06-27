package com.lexicalscope.sb.app;

import com.lexicalscope.sb.database.StoryDatabase;
import com.lexicalscope.sb.dispatch.Controller;
import com.lexicalscope.sb.logging.JdkLogger;
import com.lexicalscope.sb.logging.SbLogger;
import com.lexicalscope.sb.today.DefaultTodayView;
import com.lexicalscope.sb.today.Theme;
import com.lexicalscope.sb.today.TodayHandler;

public class Main {
   public Controller createController(final StoryDatabase db, final Theme theme) {
      final Controller result = new Controller();
      final SbLogger logger = new JdkLogger();
      result.register("/today", new TodayHandler(logger, db, theme, new DefaultTodayView(logger)));
      return result;
   }
}
