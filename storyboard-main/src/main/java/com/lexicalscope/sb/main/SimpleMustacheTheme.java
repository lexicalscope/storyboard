package com.lexicalscope.sb.main;

import java.io.IOException;
import java.io.PrintWriter;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.lexicalscope.sb.today.BeanStorySummaryTemplate;
import com.lexicalscope.sb.today.BeanTodayTemplate;
import com.lexicalscope.sb.today.StorySummaryTemplate;
import com.lexicalscope.sb.today.Theme;
import com.lexicalscope.sb.today.TodayTemplate;

public class SimpleMustacheTheme implements Theme {
   private final Mustache todayTemplate;

   public SimpleMustacheTheme() throws IOException {
      final MustacheFactory mf = new DefaultMustacheFactory();
      todayTemplate = mf.compile("today.hbs");
   }

   @Override public TodayTemplate todayTemplate() {
      return new BeanTodayTemplate();
   }

   @Override public StorySummaryTemplate storySummaryTemplate() {
      return new BeanStorySummaryTemplate();
   }

   public void output(
         final com.lexicalscope.sb.http.Template template,
         final PrintWriter writer) throws IOException {
      todayTemplate.execute(writer, template).flush();
   }
}
