package com.lexicalscope.sb;

import static com.lexicalscope.MatchersAdditional.anyOf;
import static com.lexicalscope.svm.partition.spec.MatchersSpec.receiverClass;

import org.hamcrest.Matcher;

import com.lexicalscope.svm.partition.spec.CallContext;

public class Change006 {
   /*
    * New methods are added but they are not called
    */
   public Matcher<CallContext> partitionSpecification() {
      return anyOf(
            receiverClass("TodayViews")
            );
   }
}
