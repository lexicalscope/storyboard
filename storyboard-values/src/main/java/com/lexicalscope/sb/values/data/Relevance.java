package com.lexicalscope.sb.values.data;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import com.lexicalscope.sb.Pure;


@Value public final class Relevance {
   private final int value;

   public Relevance(final int value) {
      this.value = value;
   }

   public int score() {
      return value;
   }

   @Pure public boolean greaterEqual(final int threshold) {
      return value >= threshold;
   }

   @Override public String toString() {
      return "" + value;
   }

   @Override public boolean equals(final Object obj) {
      return obj != null &&
            obj.getClass().equals(this.getClass()) &&
            ((Relevance) obj).value == value;
   }

   @Override public int hashCode() {
      return value;
   }

   public static Matcher<? super Relevance> hasRelevance(final Matcher<Integer> matcher) {
      return new FeatureMatcher<Relevance, Integer>(matcher, "value", "value") {
         @Override protected Integer featureValueOf(final Relevance actual) {
            return actual.value;
         }
      };
   }
}
