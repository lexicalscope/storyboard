package com.lexicalscope.sb.today;

import com.lexicalscope.sb.http.Template;
import com.lexicalscope.sb.http.WebResponse;

public class ReadOutputWebResponse implements WebResponse {
   @Override public void status(final int status, final String reason) {
   }

   @Override public void header(final String name, final String value) {
   }

   /*
    * this is test rig that distinguishes the output that we are given.
    * It is necessary to give meaning to the content when used by our
    * modification checking tool. Program outputs are equivalent iff
    * this response is unaffected. If the response is unaffected that
    * implies that all the values read from the template are equivalent
    */
   @Override public void content(final int status, final Template content) {
      final BeanTodayTemplate output = (BeanTodayTemplate) content;
      output.userName().toString();
      for (final BeanStorySummaryTemplate story : output.stories()) {
         story.author().toString();
         story.title().toString();
         story.summary().toString();
         story.relevance().score();
         story.id();
      }
   }
}
