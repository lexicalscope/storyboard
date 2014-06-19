package com.lexicalscope.sb.main;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;
import org.skife.jdbi.v2.tweak.ArgumentFactory;

import com.lexicalscope.sb.data.UserId;

public class UserIdArgumentFactory implements ArgumentFactory<UserId> {
    @Override
    public boolean accepts(final Class<?> expectedType, final Object value, final StatementContext ctx) {
        return value instanceof UserId;
    }

    @Override
    public Argument build(final Class<?> expectedType, final UserId value, final StatementContext ctx) {
        return new UserIdArgument(value);
    }
}