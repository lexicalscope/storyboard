package com.lexicalscope.sb.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.lexicalscope.sb.data.User;

public class UserMapper implements ResultSetMapper<User>{
   @Override public User map(final int index, final ResultSet r, final StatementContext ctx) throws SQLException {
      return new User(r.getString("name"));
   }
}