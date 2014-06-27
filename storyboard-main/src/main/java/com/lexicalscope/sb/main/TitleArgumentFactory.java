package com.lexicalscope.sb.main;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;
import org.skife.jdbi.v2.tweak.ArgumentFactory;

import com.lexicalscope.sb.values.data.Title;

public class TitleArgumentFactory implements ArgumentFactory<Title> {
    @Override
    public boolean accepts(final Class<?> expectedType, final Object value, final StatementContext ctx) {
        return value instanceof Title;
    }

    @Override
    public Argument build(final Class<?> expectedType, final Title value, final StatementContext ctx) {
        return new TitleArgument(value);
    }
}