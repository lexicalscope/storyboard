package com.lexicalscope.sb.values.data;

import java.util.Objects;

public class Summary {
   private final String summary;

   public Summary(final String summary) {
      this.summary = summary;
   }

   @Override public String toString() {
      return summary;
   }

   @Override public boolean equals(final Object obj) {
      return obj != null &&
            obj.getClass().equals(this.getClass()) &&
            Objects.equals(((Summary) obj).summary, summary);
   }

   @Override public int hashCode() {
      return summary.hashCode();
   }
}
