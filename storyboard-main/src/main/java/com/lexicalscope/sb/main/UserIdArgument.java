package com.lexicalscope.sb.main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;

import com.lexicalscope.sb.data.UserId;

public class UserIdArgument implements Argument {
    private final UserId value;

    public UserIdArgument(final UserId value) {
        this.value = value;
    }

    @Override
    public void apply(final int position, final PreparedStatement statement, final StatementContext ctx) throws SQLException {
        statement.setLong(position, value.id());
    }
}