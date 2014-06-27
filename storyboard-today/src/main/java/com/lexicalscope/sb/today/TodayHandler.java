package com.lexicalscope.sb.today;


import com.lexicalscope.sb.data.Stories;
import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.data.User;
import com.lexicalscope.sb.data.UserId;
import com.lexicalscope.sb.database.StoryDatabase;
import com.lexicalscope.sb.dispatch.Handler;
import com.lexicalscope.sb.http.WebRequest;
import com.lexicalscope.sb.http.WebResponse;
import com.lexicalscope.sb.logging.SbLogger;

public class TodayHandler implements Handler {
   private final StoryDatabase db;
   private final Theme theme;
   private final TodayView view;
   private final SbLogger logger;

   public TodayHandler(final SbLogger logger, final StoryDatabase db, final Theme theme, final TodayView view) {
      this.logger = logger;
      this.db = db;
      this.theme = theme;
      this.view = view;
   }

   @Override public void get(final WebRequest request, final WebResponse response) {
      final UserId userId = UserId.fromString(request.getCookie("userid"));
      logger.debug("viewing user %s", userId);

      final User user = db.userData().findUserById(userId);
      final Stories stories = db.todayData().storyFor(userId);

      final TodayTemplate todayTemplate = theme.todayTemplate();
      todayTemplate.userName(user.name());

      for (final Story story : stories) {
         view.storySummaryView(story).outputTo(theme, todayTemplate);
      }

      response.content(200, todayTemplate);
   }
}
