package com.lexicalscope.sb.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.lexicalscope.sb.data.User;
import com.lexicalscope.sb.data.UserId;

public class UserMapper implements ResultSetMapper<User>{
   @Override public User map(final int index, final ResultSet r, final StatementContext ctx) throws SQLException {
      return new User(new UserId(r.getLong("id")), r.getString("name"));
   }
}