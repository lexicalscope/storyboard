package com.lexicalscope.sb;

import static com.lexicalscope.MatchersAdditional.anyOf;
import static com.lexicalscope.svm.partition.spec.MatchersSpec.receiverClass;

import org.hamcrest.Matcher;

import com.lexicalscope.svm.partition.spec.CallContext;

public class Change004 {
   /*
    * We are reading info from the DB in a different order, but all the query methods are pure.
    * We add the summaries too the TodayTemplate in the same order established by Change003
    *
    * So here, TodayTemplate and WebResponse are preserved.
    *
    * However, what would otherwise be a refactoring is spoilt by the presence of logging statements
    * in the reordered part (StorySummaryView). Our specification can easily handle this by including
    * the logger in the affected part.
    */
   public Matcher<CallContext> partitionSpecification() {
      return anyOf(
            receiverClass("StorySummaryTemplate"),
            receiverClass("SortingStoriesView"),
            /*
             * Summaries are processed in a different order
             */
            receiverClass("TodayViews"),
            /*
             * all summary views and partial views may be affected
             */
            receiverClass("StorySummaryView"),
            receiverClass("StorySummaryPartialView"),
            /*
             * Logging is affected since stories are viewed in a different order
             */
            receiverClass("SbLogger")
            );
   }
}
