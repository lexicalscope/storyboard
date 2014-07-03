package com.lexicalscope.sb;

import static com.lexicalscope.MatchersAdditional.anyOf;
import static com.lexicalscope.svm.partition.spec.MatchersSpec.receiverClass;

import org.hamcrest.Matcher;

import com.lexicalscope.svm.partition.spec.CallContext;

public class Change008 {
   /*
    * Highlighted stories are added to the output. This change specification is correct,
    * but the first implementation has a bug (side effect of the sort). So this specification
    * will detect that the story summary views are no longer passed the stories in the
    * same order.
    */
   public Matcher<CallContext> partitionSpecification() {
      return anyOf(
            /*
             * Highlighted stories are added to the output
             */
            receiverClass("WebResponse"),
            /*
             * Views are created for the highlights
             */
            receiverClass("TodayViews"),
            receiverClass("StoryHighlightView"),
            /*
             * Templates are created for the highlights
             */
            receiverClass("Theme"),
            receiverClass("StoryHighlightTemplate"),
            /*
             * Highlights are written to the template
             */
            receiverClass("StorySummariesTemplate"),
            /*
             * The stories passes the stories to the highlight view
             */
            receiverClass("SortingStoriesView")
            );
   }
}
