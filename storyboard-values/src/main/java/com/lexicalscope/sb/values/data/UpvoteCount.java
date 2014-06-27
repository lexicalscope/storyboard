package com.lexicalscope.sb.values.data;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

@Value public class UpvoteCount {
   private final int value;

   public UpvoteCount(final int value) {
      this.value = value;
   }

   public int count() {
      return value;
   }

   @Override public String toString() {
      return "" + value;
   }

   @Override public boolean equals(final Object obj) {
      return obj != null &&
            obj.getClass().equals(this.getClass()) &&
            ((UpvoteCount) obj).value == value;
   }

   @Override public int hashCode() {
      return value;
   }

   public static Matcher<UpvoteCount> hasUpvoteCount(final Matcher<Integer> matcher) {
      return new FeatureMatcher<UpvoteCount, Integer>(matcher, "count", "count") {
         @Override protected Integer featureValueOf(final UpvoteCount actual) {
            return actual.value;
         }
      };
   }
}
