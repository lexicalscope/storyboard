package com.lexicalscope.sb.main;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;
import org.skife.jdbi.v2.tweak.ArgumentFactory;

import com.lexicalscope.sb.values.data.Summary;

public class SummaryArgumentFactory implements ArgumentFactory<Summary> {
    @Override
    public boolean accepts(final Class<?> expectedType, final Object value, final StatementContext ctx) {
        return value instanceof Summary;
    }

    @Override
    public Argument build(final Class<?> expectedType, final Summary value, final StatementContext ctx) {
        return new SummaryArgument(value);
    }
}