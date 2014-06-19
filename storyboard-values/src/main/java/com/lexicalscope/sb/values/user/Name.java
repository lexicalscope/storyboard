package com.lexicalscope.sb.values.user;

import java.util.Objects;

public class Name {
   private final String name;

   public Name(final String name) {
      this.name = name;
   }

   @Override public String toString() {
      return name;
   }

   @Override public boolean equals(final Object obj) {
      return obj != null &&
            obj.getClass().equals(this.getClass()) &&
            Objects.equals(((Name) obj).name, name);
   }

   @Override public int hashCode() {
      return name.hashCode();
   }
}
