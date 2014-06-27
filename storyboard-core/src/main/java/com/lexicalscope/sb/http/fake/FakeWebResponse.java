package com.lexicalscope.sb.http.fake;

import java.util.Objects;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import com.lexicalscope.sb.http.Template;
import com.lexicalscope.sb.http.WebResponse;

public class FakeWebResponse implements WebResponse {
   private int status;
   private String reason;
   private Template content;

   @Override public void status(final int status, final String reason) {
      this.status = status;
      this.reason = reason;
   }

   public int status() {
      return status;
   }

   public String reason() {
      return reason;
   }

   @Override public void header(final String name, final String value) {

   }

   @Override public void content(final int status, final Template content) {
      this.status = status;
      this.content = content;
   }

   public Template content() {
      return content;
   }

   public static Matcher<FakeWebResponse> statusIs(final int status) {
      return new TypeSafeDiagnosingMatcher<FakeWebResponse>() {
         @Override public void describeTo(final Description description) {
            description.appendText("status of ").appendValue(status);
         }

         @Override protected boolean matchesSafely(final FakeWebResponse item, final Description mismatchDescription) {
            mismatchDescription.appendText("status of ").appendValue(item.status());
            return Objects.equals(status, item.status());
         }
      };
   }

   public static Matcher<FakeWebResponse> contentIs(final Template content) {
      return new TypeSafeDiagnosingMatcher<FakeWebResponse>() {
         @Override public void describeTo(final Description description) {
            description.appendText("content is ").appendValue(content);
         }

         @Override protected boolean matchesSafely(final FakeWebResponse item, final Description mismatchDescription) {
            mismatchDescription.appendText("content is ").appendValue(item.content());
            return Objects.equals(content, item.content());
         }
      };
   }
}
