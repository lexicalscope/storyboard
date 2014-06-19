package com.lexicalscope.sb.main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;

import com.lexicalscope.sb.values.data.Title;

public class TitleArgument implements Argument {
    private final Title value;

    public TitleArgument(final Title value) {
        this.value = value;
    }

    @Override
    public void apply(final int position, final PreparedStatement statement, final StatementContext ctx) throws SQLException {
        statement.setString(position, value.toString());
    }
}