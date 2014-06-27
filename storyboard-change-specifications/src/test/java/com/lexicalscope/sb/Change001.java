package com.lexicalscope.sb;

import static com.lexicalscope.MatchersAdditional.*;
import static com.lexicalscope.svm.partition.spec.MatchersSpec.*;
import static org.hamcrest.Matchers.lessThan;

import org.hamcrest.Matcher;

import com.lexicalscope.svm.partition.spec.CallContext;

public class Change001 {
   public Matcher<CallContext> partitionSpecification() {
      return anyOf(viewForIrrelevantStory(), templateForIrrelevantStory(), mainTemplate(), response(), receiverClass("SbLogger"));
   }

   private Matcher<? super CallContext> response() {
      return receiverClass("WebResponse");
   }

   /*
    * "DefaultStorySummaryView" - instantiated with irrelevant story
    */
   public Matcher<CallContext> viewForIrrelevantStory() {
      return allOf(receiverClass("DefaultStorySummaryView"), with(parameter("story.relevance.value", value(integer(lessThan(10))))));
   }

   /*
    * "StorySummaryTemplate" - this is output, only one is ruined (not created)
    * need to look back up the stack and see if it is being created as a
    * consequence of the irrelevant story
    *
    * "Theme" - affected when creating "StorySummaryTemplate", but its a factory
    * so template creation should be implemented as pure. Only the produced
    * StorySummaryTemplate is really affected.
    */
   public Matcher<CallContext> templateForIrrelevantStory() {
      return allOf(receiverClass("StorySummaryTemplate"), previously("DefaultStorySummaryView", "outputTo", with(receiver(field("story.relevance.value", value(integer(lessThan(10))))))));
      // note that the field may be a symbolic value, can we use guards here?
   }

   /*
    * "TodayTemplate" - full output could be ruined, but we don't care
    */
   public Matcher<? super CallContext> mainTemplate() {
      return receiverClass("TodayTemplate");
   }
}
