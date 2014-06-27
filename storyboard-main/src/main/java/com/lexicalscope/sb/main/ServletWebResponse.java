package com.lexicalscope.sb.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.lexicalscope.sb.http.Template;
import com.lexicalscope.sb.http.WebResponse;

public class ServletWebResponse implements WebResponse {
   private final HttpServletResponse response;
   private final SimpleMustacheTheme theme;

   public ServletWebResponse(final HttpServletResponse response, final SimpleMustacheTheme theme) {
      this.response = response;
      this.theme = theme;
   }

   @Override public void status(final int status, final String reason) {

   }

   @Override public void header(final String name, final String value) {

   }

   @Override public void content(final int status, final Template template) {
      response.setStatus(status);
      PrintWriter writer;
      try {
         writer = response.getWriter();
         theme.output(template, writer);
         writer.flush();
      } catch (final IOException e) {
         throw new RuntimeException(e);
      }
   }
}
