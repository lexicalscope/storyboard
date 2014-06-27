package com.lexicalscope.sb.today;


public class CompositeStorySummaryPartialView implements StorySummaryPartialView {
   private final StorySummaryPartialView delegate0;
   private final StorySummaryPartialView delegate1;

   public CompositeStorySummaryPartialView(final StorySummaryPartialView delegate0, final StorySummaryPartialView delegate1) {
      this.delegate0 = delegate0;
      this.delegate1 = delegate1;
   }

   @Override public void outputTo(final Theme theme, final StorySummaryTemplate storyTemplate) {
      delegate0.outputTo(theme, storyTemplate);
      delegate1.outputTo(theme, storyTemplate);
   }
}
