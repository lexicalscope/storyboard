package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.User;
import com.lexicalscope.sb.data.UserId;
import com.lexicalscope.sb.database.UserData;

public class FakeUserData implements UserData {
   private User user;

   @Override public User findUserById(final UserId username) {
      return user;
   }

   public FakeUserData user(final User user) {
      this.user = user;
      return this;
   }
}
