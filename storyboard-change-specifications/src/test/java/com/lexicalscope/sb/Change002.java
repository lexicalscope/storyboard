package com.lexicalscope.sb;

import static com.lexicalscope.MatchersAdditional.anyOf;
import static com.lexicalscope.svm.partition.spec.MatchersSpec.receiverClass;

import org.hamcrest.Matcher;

import com.lexicalscope.svm.partition.spec.CallContext;

public class Change002 {
   /*
    * Importantly, DefaultStorySummaryCoreView is not affected
    */
   public Matcher<CallContext> partitionSpecification() {
      return anyOf(
            /*
             * "StorySummaryTemplate" - this is output, all story summaries
             * could be ruined (we are adding a badge to each one)
             */
            receiverClass("StorySummaryTemplate"),
            /*
             * "WebResponse" - full output could be ruined, but we don't care
             */
            receiverClass("WebResponse"),
            /*
             * The badge view is constructed and composed with the existing views
             */
            receiverClass("CompositeStorySummaryCoreView"),
            receiverClass("StorySummaryBadgeView"),
            receiverClass("DefaultTodayView"));
   }
}
