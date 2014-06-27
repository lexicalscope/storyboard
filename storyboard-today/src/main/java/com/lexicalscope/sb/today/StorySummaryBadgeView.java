package com.lexicalscope.sb.today;

import com.lexicalscope.sb.data.Story;

public class StorySummaryBadgeView implements StorySummaryPartialView {
   private final Story story;

   public StorySummaryBadgeView(final Story story) {
      this.story = story;
   }

   @Override public void outputTo(final Theme theme, final StorySummaryTemplate storyTemplate) {
      final int upvotes = story.upvoteCount().count();
      if(upvotes >= 35) {
         storyTemplate.showGoldBadge();
      } else if (upvotes >= 15) {
         storyTemplate.showSilverBadge();
      } else if (upvotes >= 5) {
         storyTemplate.showBronzeBadge();
      }
   }
}