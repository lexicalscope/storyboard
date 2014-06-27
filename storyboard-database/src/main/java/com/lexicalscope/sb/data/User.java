package com.lexicalscope.sb.data;

public class User {
   private final String name;
   private final UserId id;

   public User(final UserId id, final String name) {
      this.id = id;
      this.name = name;
   }

   public String name() {
      return name;
   }

   public String getName() {
      return name();
   }

   public UserId id() {
      return id;
   }

   public UserId getId() {
      return id();
   }

   public static UserBuilder user() {
      return new UserBuilder();
   }

   public static class UserBuilder {
      private String name;
      private UserId id;

      public UserBuilder name(final String displayName) {
         this.name = displayName;
         return this;
      }

      public UserBuilder id(final long id) {
         this.id = new UserId(id);
         return this;
      }

      public User make() {
         return new User(id, name);
      }
   }
}
