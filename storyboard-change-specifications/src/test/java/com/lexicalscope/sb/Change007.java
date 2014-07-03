package com.lexicalscope.sb;

import static com.lexicalscope.MatchersAdditional.anyOf;
import static com.lexicalscope.svm.partition.spec.MatchersSpec.receiverClass;

import org.hamcrest.Matcher;

import com.lexicalscope.svm.partition.spec.CallContext;

public class Change007 {
   /*
    * We read any new output, the today template is queried for any highlighted stories,
    * but we have not updated the view to produce highlights, so non is present so no
    * other thus no other objects are affected by this modification.
    */
   public Matcher<CallContext> partitionSpecification() {
      return anyOf(
            receiverClass("WebResponse"),
            receiverClass("TodayTemplate")
            );
   }
}
