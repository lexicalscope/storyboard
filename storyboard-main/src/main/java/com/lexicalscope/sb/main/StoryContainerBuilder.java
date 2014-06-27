package com.lexicalscope.sb.main;

import java.util.ArrayList;
import java.util.List;

import org.skife.jdbi.v2.ContainerBuilder;

import com.lexicalscope.sb.data.Story;
import com.lexicalscope.sb.data.Stories;

public class StoryContainerBuilder implements ContainerBuilder<Stories> {
   private final List<Story> story = new ArrayList<>();

   @Override public ContainerBuilder<Stories> add(final Object it) {
      story.add((Story) it);
      return this;
   }

   @Override public Stories build() {
      return new Stories(story);
   }
}
