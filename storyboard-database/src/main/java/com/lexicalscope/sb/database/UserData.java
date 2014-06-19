package com.lexicalscope.sb.database;

import com.lexicalscope.sb.data.User;
import com.lexicalscope.sb.data.UserId;

public interface UserData {
   User findUserById(UserId username);
}
