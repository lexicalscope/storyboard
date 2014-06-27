package com.lexicalscope.sb;

import static com.lexicalscope.MatchersAdditional.anyOf;
import static com.lexicalscope.svm.partition.spec.MatchersSpec.receiverClass;

import org.hamcrest.Matcher;

import com.lexicalscope.svm.partition.spec.CallContext;

public class Change003 {
   /*
    * We take care to make sure StorySummaryTemplate is not affected
    * This changes also does not affect the logging
    */
   public Matcher<CallContext> partitionSpecification() {
      return anyOf(
            /*
             * "TodayTemplate" - full output could be ruined since we change the order of the output
             */
            receiverClass("TodayTemplate"),
            receiverClass("WebResponse"),
            /*
             * This constructs a different view strategy, so contains slightly different code.
             * The strategy construction could perhaps be abstracted to deal with this, but
             * not sure it is worth while.
             */
            receiverClass("DefaultTodayViews"),

            /*
             * replaced by SortingStoriesView
             */
            receiverClass("DefaultStoriesView"),

            /*
             * replaces DefaultStoriesView, also creates some temporary
             * objects which should be included in the specification
             * we can probably deal with this automatically by specifying
             * u part = com.lexicalscope.sb.data.* - (a part)
             */
            receiverClass("SortingStoriesView"));
   }
}
