package com.lexicalscope.sb.dispatch;

import static com.lexicalscope.sb.http.fake.FakeWebResponse.statusIs;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.lexicalscope.sb.http.WebRequest;
import com.lexicalscope.sb.http.WebResponse;
import com.lexicalscope.sb.http.fake.FakeWebRequest;
import com.lexicalscope.sb.http.fake.FakeWebResponse;

public class TestController {
   private final FakeWebRequest request = new FakeWebRequest();
   private final FakeWebResponse response = new FakeWebResponse();
   private final Controller controller = new Controller();

   @Test public void noHandlerGives404()
   {
      request.path("/my/path");

      controller.handle(request, response);

      assertThat(response, statusIs(404));
   }

   @Test public void handlerIsInvoked()
   {
      controller.register("/my/path", new Handler() {
         @Override public void get(final WebRequest request, final WebResponse response) {
            response.status(200, "OK");
         }
      });
      request.path("/my/path").method("GET");

      controller.handle(request, response);

      assertThat(response, statusIs(200));
   }
}
