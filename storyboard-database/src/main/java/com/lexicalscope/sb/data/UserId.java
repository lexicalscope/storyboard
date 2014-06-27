package com.lexicalscope.sb.data;

public class UserId {
   private final long id;

   public UserId(final long id) {
      this.id = id;
   }

   public long id() {
      return id;
   }

   public long getId() {
      return id();
   }

   @Override public String toString() {
      return "" + id;
   }

   public static UserId fromString(final String id) {
      return id == null ? null : new UserId(Long.parseLong(id));
   }
}
