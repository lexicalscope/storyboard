package com.lexicalscope.sb.today;

import com.lexicalscope.sb.values.data.Title;

public class BeanStoryHighlightTemplate implements StoryHighlightTemplate {
   private long id;
   private Title title;

   @Override public void id(final long id) {
      this.id = id;
   }

   public long id() {
      return id;
   }

   @Override public void title(final Title title) {
      this.title = title;
   }

   protected Title title() {
      return title;
   }
}
