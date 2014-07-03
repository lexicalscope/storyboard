package com.lexicalscope.sb.today;

import static com.lexicalscope.MatchersAdditional.has;
import static com.lexicalscope.sb.today.BeanStorySummaryTemplate.authoredBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import com.lexicalscope.MatchersAdditional;

public class BeanTodayTemplate implements TodayTemplate {
   private String userName;
   private final List<BeanStorySummaryTemplate> stories = new ArrayList<>();
   private final List<BeanStoryHighlightTemplate> highlights = new ArrayList<>();

   @Override public void userName(final String name) {
      this.userName = name;
   }

   @Override public void addStory(final StorySummaryTemplate storyTemplate) {
      stories.add((BeanStorySummaryTemplate) storyTemplate);
   }

   @Override public void addHighlight(final StoryHighlightTemplate storyTemplate) {
      highlights.add((BeanStoryHighlightTemplate) storyTemplate);
   }

   protected String userName() {
      return userName;
   }

   public List<BeanStorySummaryTemplate> stories() {
      return stories;
   }

   public List<BeanStoryHighlightTemplate> highlights() {
      return highlights;
   }

   public static Matcher<? super BeanTodayTemplate> showsUser(final String name) {
      return new TypeSafeDiagnosingMatcher<BeanTodayTemplate>() {
         @Override public void describeTo(final Description description) {
            description.appendText("name shown is ").appendValue(name);
         }

         @Override protected boolean matchesSafely(final BeanTodayTemplate item, final Description mismatchDescription) {
            mismatchDescription.appendText("name shown is ").appendValue(item.userName());
            return Objects.equals(name, item.userName());
         }
      };
   }

   @SafeVarargs public static Matcher<BeanTodayTemplate> showsStoryFrom(final String name, final Matcher<BeanStorySummaryTemplate> ... conjoin) {
      final Matcher<Iterable<BeanStorySummaryTemplate>> authoredByMatcher = has(MatchersAdditional.allOf(authoredBy(name), conjoin)).inAnyOrder();
      return new TypeSafeDiagnosingMatcher<BeanTodayTemplate>(){

         @Override public void describeTo(final Description description) {
            description.appendText("contains ").appendDescriptionOf(authoredByMatcher);
         }

         @Override protected boolean matchesSafely(final BeanTodayTemplate item, final Description mismatchDescription) {
            mismatchDescription.appendText("contains ");
            authoredByMatcher.describeMismatch(item.stories(), mismatchDescription);
            return authoredByMatcher.matches(item.stories());
         }};
   }
}
