package com.lexicalscope.sb.today;

import com.lexicalscope.sb.database.StoryDatabase;
import com.lexicalscope.sb.http.WebRequest;
import com.lexicalscope.sb.http.WebResponse;
import com.lexicalscope.sb.http.fake.FakeWebResponse;
import com.lexicalscope.sb.logging.JdkLogger;
import com.lexicalscope.sb.logging.SbLogger;

public class TodayTestRig {
   public FakeWebResponse runTodayHandler(final StoryDatabase db, final WebRequest request)
   {
      final FakeWebResponse response = new FakeWebResponse();
      final SbLogger logger = new JdkLogger();
      runTodayHandler(logger, db, request, response);
      return response;
   }

   private void runTodayHandler(final SbLogger logger, final StoryDatabase db, final WebRequest request, final WebResponse response) {
      new TodayHandler(logger, db, new SimpleTheme(), new DefaultTodayViews(logger)).get(request, response);
   }

   // entry point for test generation
   public void runTodayHandlerAndReadOutput(final StoryDatabase db, final WebRequest request) {
      final WebResponse response = new ReadOutputWebResponse();
      final SbLogger logger = new ReadOutputLogger();
      runTodayHandler(logger, db, request, response);
   }
}
