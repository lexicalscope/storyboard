package com.lexicalscope.sb.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lexicalscope.sb.data.Story.StoryBuilder;

public class Stories implements Iterable<Story> {
   private final List<Story> stories;

   public Stories(final List<Story> story) {
      this.stories = story;
   }

   @Override public Iterator<Story> iterator() {
      return stories.iterator();
   }

   public static StoriesBuilder stories() {
      return new StoriesBuilder();
   }

   public static class StoriesBuilder {
      private final List<Story> stories = new ArrayList<>();

      public StoriesBuilder with(final StoryBuilder story) {
         stories.add(story.build());
         return this;
      }

      public Stories make() {
         return new Stories(new ArrayList<>(stories));
      }
   }
}
