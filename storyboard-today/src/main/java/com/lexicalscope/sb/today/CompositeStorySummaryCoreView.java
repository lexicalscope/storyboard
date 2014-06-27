package com.lexicalscope.sb.today;


public class CompositeStorySummaryCoreView implements StorySummaryCoreView {
   private final StorySummaryCoreView delegate0;
   private final StorySummaryCoreView delegate1;

   public CompositeStorySummaryCoreView(final StorySummaryCoreView delegate0, final StorySummaryCoreView delegate1) {
      this.delegate0 = delegate0;
      this.delegate1 = delegate1;
   }

   @Override public void outputTo(final Theme theme, final StorySummaryTemplate storyTemplate) {
      delegate0.outputTo(theme, storyTemplate);
      delegate1.outputTo(theme, storyTemplate);
   }
}
