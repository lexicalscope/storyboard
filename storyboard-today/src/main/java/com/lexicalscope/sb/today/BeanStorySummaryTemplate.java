package com.lexicalscope.sb.today;

import static org.hamcrest.Matchers.*;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import com.lexicalscope.sb.values.data.Relevance;
import com.lexicalscope.sb.values.data.Summary;
import com.lexicalscope.sb.values.data.Title;
import com.lexicalscope.sb.values.user.Name;

public class BeanStorySummaryTemplate implements StorySummaryTemplate {
   private Name author;
   private Title title;
   private Summary summary;
   private Relevance relevance;
   private long id;

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

   @Override public void author(final Name author) {
      this.author = author;
   }

   protected Name author() {
      return author;
   }

   @Override public void summary(final Summary summary) {
      this.summary = summary;
   }

   protected Summary summary() {
      return summary;
   }

   @Override public void relevance(final Relevance relevance) {
      this.relevance = relevance;
   }

   protected Relevance relevance() {
      return relevance;
   }

   public static Matcher<BeanStorySummaryTemplate> authoredBy(final String name) {
      return new FeatureMatcher<BeanStorySummaryTemplate, Name>(hasToString(equalTo(name)), "name", "name") {
         @Override protected Name featureValueOf(final BeanStorySummaryTemplate actual) {
            return actual.author();
         }
      };
   }

   public static Matcher<BeanStorySummaryTemplate> titleIs(final String title) {
      return new FeatureMatcher<BeanStorySummaryTemplate, Title>(hasToString(equalTo(title)), "title", "title") {
         @Override protected Title featureValueOf(final BeanStorySummaryTemplate actual) {
            return actual.title();
         }
      };
   }

   public static Matcher<BeanStorySummaryTemplate> summaryIs(final String summary) {
      return new FeatureMatcher<BeanStorySummaryTemplate, Summary>(hasToString(equalTo(summary)), "summary", "summary") {
         @Override protected Summary featureValueOf(final BeanStorySummaryTemplate actual) {
            return actual.summary();
         }
      };
   }

   public static Matcher<BeanStorySummaryTemplate> relevance(final int relevance) {
      return new FeatureMatcher<BeanStorySummaryTemplate, Relevance>(Relevance.hasRelevance(equalTo(relevance)), "relevance", "relevance") {
         @Override protected Relevance featureValueOf(final BeanStorySummaryTemplate actual) {
            return actual.relevance();
         }
      };
   }

   @Override public String toString() {
      return String.format("(StorySummary %s)", author);
   }
}
