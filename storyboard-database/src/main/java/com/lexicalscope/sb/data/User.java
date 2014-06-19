package com.lexicalscope.sb.data;

public class User {
   private final String name;

   public User(final String name) {
      this.name = name;
   }

   public String name() {
      return name;
   }

   public String getName() {
      return name;
   }

   public static UserBuilder user() {
      return new UserBuilder();
   }

   public static class UserBuilder {
      private String displayName;

      public UserBuilder name(final String displayName) {
         this.displayName = displayName;
         return this;
      }

      public User make() {
         return new User(displayName);
      }
   }
}
