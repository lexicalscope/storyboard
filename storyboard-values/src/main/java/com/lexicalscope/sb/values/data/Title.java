package com.lexicalscope.sb.values.data;

import java.util.Objects;

public class Title {
   private final String title;

   public Title(final String title) {
      this.title = title;
   }

   @Override public String toString() {
      return title;
   }

   @Override public boolean equals(final Object obj) {
      return obj != null &&
            obj.getClass().equals(this.getClass()) &&
            Objects.equals(((Title) obj).title, title);
   }

   @Override public int hashCode() {
      return title.hashCode();
   }
}
