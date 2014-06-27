package com.lexicalscope.sb.today;

import static com.lexicalscope.sb.data.Story.story;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class TestStorySummaryBadgeView {
   @Rule public final JUnitRuleMockery context = new JUnitRuleMockery();

   @Mock private Theme theme;
   @Mock private StorySummaryTemplate storyTemplate;

   @Test public void bronzeBadge() {
      context.checking(new Expectations(){{
         oneOf(storyTemplate).showBronzeBadge();
      }});

      new StorySummaryBadgeView().outputTo(story().upvoteCount(5).build(), theme, storyTemplate);
   }
}
