package com.lexicalscope.sb.main;

import org.skife.jdbi.v2.ContainerBuilder;
import org.skife.jdbi.v2.tweak.ContainerFactory;

import com.lexicalscope.sb.data.Stories;

public class StoryContainerFactory implements ContainerFactory<Stories> {
   @Override public boolean accepts(final Class<?> type) {
      return type.isAssignableFrom(Stories.class);
   }

   @Override public ContainerBuilder<Stories> newContainerBuilderFor(final Class<?> type) {
      return new StoryContainerBuilder();
   }
}
