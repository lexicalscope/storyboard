package com.lexicalscope.sb.data;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import com.lexicalscope.sb.values.data.Relevance;
import com.lexicalscope.sb.values.data.Summary;
import com.lexicalscope.sb.values.data.Title;
import com.lexicalscope.sb.values.data.UpvoteCount;
import com.lexicalscope.sb.values.data.Value;
import com.lexicalscope.sb.values.user.Name;

@Value public final class Story {
   private final long id;
   private final Name authorName;
   private final Title title;
   private final Summary summary;
   private final Relevance relevance;
   private final long authorId;
   private final UpvoteCount upvoteCount;

   public Story(
         final long id,
         final Name authorName,
         final long authorId,
         final Title title,
         final Summary summary,
         final Relevance relevance,
         final UpvoteCount upvoteCount) {
      this.id = id;
      this.authorName = authorName;
      this.authorId = authorId;
      this.title = title;
      this.summary = summary;
      this.relevance = relevance;
      this.upvoteCount = upvoteCount;
   }

   public long id() {
      return id;
   }

   public Title title() {
      return title;
   }

   public Title getTitle() {
      return title();
   }

   public Name author() {
      return authorName;
   }

   public long authorId() {
      return authorId;
   }

   public long getAuthorId() {
      return authorId();
   }

   public Summary summary() {
      return summary;
   }

   public Summary getSummary() {
      return summary();
   }

   public Relevance relevance() {
      return relevance;
   }

   public UpvoteCount upvoteCount() {
      return upvoteCount;
   }

   public UpvoteCount getUpvoteCount() {
      return upvoteCount();
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
      private UpvoteCount upvoteCount = new UpvoteCount(0);

      public StoryBuilder author(final Name name) {
         this.authorName = name;
         return this;
      }

      public StoryBuilder author(final String name) {
         return author(new Name(name));
      }

      public Story build() {
         return new Story(id, authorName, authorId, title, summary, relevance, upvoteCount);
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

      public StoryBuilder upvoteCount(final UpvoteCount upvoteCount) {
         this.upvoteCount = upvoteCount;
         return this;
      }

      public StoryBuilder upvoteCount(final int upvoteCount) {
         return upvoteCount(new UpvoteCount(upvoteCount));
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

   public static Matcher<Story> theTitle(final Matcher<? super Title> titleMatcher) {
      return new FeatureMatcher<Story, Title>(titleMatcher, "title", "title") {
         @Override protected Title featureValueOf(final Story actual) {
            return actual.title();
         }
      };
   }

   public static Matcher<Story> theScore(final Matcher<? super Relevance> relevanceMatcher) {
      return new FeatureMatcher<Story, Relevance>(relevanceMatcher, "relevance", "relevance") {
         @Override protected Relevance featureValueOf(final Story actual) {
            return actual.relevance();
         }
      };
   }

   public static Matcher<Story> theUpvotes(final Matcher<? super UpvoteCount> upvoteMatcher) {
      return new FeatureMatcher<Story, UpvoteCount>(upvoteMatcher, "upvoteCount", "upvoteCount") {
         @Override protected UpvoteCount featureValueOf(final Story actual) {
            return actual.upvoteCount();
         }
      };
   }
}
