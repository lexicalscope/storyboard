package com.lexicalscope.sb;

import static com.lexicalscope.MatchersAdditional.anyOf;
import static com.lexicalscope.svm.partition.spec.MatchersSpec.receiverClass;

import org.hamcrest.Matcher;

import com.lexicalscope.svm.partition.spec.CallContext;

public class Change005 {
   /*
    * We add new views and templates to enable us to highlight
    * particular stories. But we don't use them, so other views
    * and the output are not affected.
    */
   public Matcher<CallContext> partitionSpecification() {
      return anyOf(
            receiverClass("StoryHighlightTemplate"),
            receiverClass("StoryHighlightView"),
            receiverClass("TodayTemplate"),
            receiverClass("StorySummariesTemplate"),
            receiverClass("Theme")
            );
   }
}
