package com.lexicalscope.sb;

import org.hamcrest.Matcher;

import com.lexicalscope.svm.partition.spec.CallContext;

public class Change009 {
   /*
    * Corrected implementation of previous change
    */
   public Matcher<CallContext> partitionSpecification() {
      return new Change008().partitionSpecification();
   }
}
