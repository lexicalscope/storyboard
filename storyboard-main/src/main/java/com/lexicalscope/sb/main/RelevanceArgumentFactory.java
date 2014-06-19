package com.lexicalscope.sb.main;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;
import org.skife.jdbi.v2.tweak.ArgumentFactory;

import com.lexicalscope.sb.values.data.Relevance;

public class RelevanceArgumentFactory implements ArgumentFactory<Relevance> {
    @Override
    public boolean accepts(final Class<?> expectedType, final Object value, final StatementContext ctx) {
        return value instanceof Relevance;
    }

    @Override
    public Argument build(final Class<?> expectedType, final Relevance value, final StatementContext ctx) {
        return new RelevanceArgument(value);
    }
}