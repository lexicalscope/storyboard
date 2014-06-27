package com.lexicalscope.sb.data;

import com.lexicalscope.sb.Pure;
import com.lexicalscope.sb.values.data.Relevance;
import com.lexicalscope.sb.values.data.Summary;
import com.lexicalscope.sb.values.data.Title;
import com.lexicalscope.sb.values.user.Name;

public final class Story {
   private final long id;
   private final Name authorName;
   private final Title title;
   private final Summary summary;
   private final Relevance relevance;
   private final long authorId;

   public Story(
         final long id,
         final Name authorName,
         final long authorId,
         final Title title,
         final Summary summary,
         final Relevance relevance) {
      this.id = id;
      this.authorName = authorName;
      this.authorId = authorId;
      this.title = title;
      this.summary = summary;
      this.relevance = relevance;
   }

   public long id() {
      return id;
   }

   @Pure public Title title() {
      return title;
   }

   @Pure public Title getTitle() {
      return title();
   }

   @Pure public Name author() {
      return authorName;
   }

   @Pure public long authorId() {
      return authorId;
   }

   @Pure public long getAuthorId() {
      return authorId();
   }

   @Pure public Summary summary() {
      return summary;
   }

   @Pure public Summary getSummary() {
      return summary();
   }

   @Pure public Relevance relevance() {
      return relevance;
   }

   public static StoryBuilder story() {
      return new StoryBuilder();
   }

   public static class StoryBuilder {
      private long id;
      private Name authorName;
      private long authorId;
      private Title title;
      private Summary summary;
      private Relevance relevance;

      public StoryBuilder author(final Name name) {
         this.authorName = name;
         return this;
      }

      public StoryBuilder author(final String name) {
         return author(new Name(name));
      }

      public Story build() {
         return new Story(id, authorName, authorId, title, summary, relevance);
      }

      public StoryBuilder title(final Title title) {
         this.title = title;
         return this;
      }

      public StoryBuilder title(final String title) {
         return title(new Title(title));
      }

      public StoryBuilder summary(final Summary summary) {
         this.summary = summary;
         return this;
      }

      public StoryBuilder summary(final String summary) {
         return summary(new Summary(summary));
      }

      public StoryBuilder relevance(final Relevance relevance) {
         this.relevance = relevance;
         return this;
      }

      public StoryBuilder relevance(final int relevance) {
         return relevance(new Relevance(relevance));
      }

      public StoryBuilder id(final long id) {
         this.id = id;
         return this;
      }

      public StoryBuilder authorId(final long id) {
         authorId = id;
         return this;
      }
   }
}
