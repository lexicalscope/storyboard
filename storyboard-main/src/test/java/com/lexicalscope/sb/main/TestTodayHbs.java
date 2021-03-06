package com.lexicalscope.sb.main;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.lexicalscope.sb.today.StoryHighlightTemplate;
import com.lexicalscope.sb.today.StorySummaryTemplate;
import com.lexicalscope.sb.today.TodayTemplate;
import com.lexicalscope.sb.values.data.Title;

public class TestTodayHbs {
   @Rule public final TemporaryFolder temporary = new TemporaryFolder();
   private SimpleMustacheTheme theme;
   private TodayTemplate todayTemplate;

   @Before public void setupTheme() throws IOException {
      theme = new SimpleMustacheTheme();
      todayTemplate = theme.todayTemplate();
   }

   @Test public void goldBadgesShown() throws IOException {
      final StorySummaryTemplate story1 = story1();
      story1.showGoldBadge();
      outputStory(story1);

      assertTextInElement(storyBadge1(), "(gold badge)");
   }

   @Test public void silverBadgesShown() throws IOException {
      final StorySummaryTemplate story1 = story1();
      story1.showSilverBadge();
      outputStory(story1);

      assertTextInElement(storyBadge1(), "(silver badge)");
   }

   @Test public void bronzeBadgesShown() throws IOException {
      final StorySummaryTemplate story1 = story1();
      story1.showBronzeBadge();
      outputStory(story1);

      assertTextInElement(storyBadge1(), "(bronze badge)");
   }

   @Test public void noBadgesShown() throws IOException {
      outputStory(story1());

      assertTextInElement(storyBadge1(), "(no badge)");
   }

   @Test public void highlightsShown() throws IOException {
      outputHighlight(highlight1());

      assertTextInElement("story-highlight-title-1", "my story");
   }

   private void outputStory(final StorySummaryTemplate storySummaryTemplate) throws IOException, FileNotFoundException, MalformedURLException {
      todayTemplate.addStory(storySummaryTemplate);

      outputTemplate();
   }

   private void outputHighlight(final StoryHighlightTemplate storyHighlightTemplate) throws IOException, FileNotFoundException, MalformedURLException {
      todayTemplate.addHighlight(storyHighlightTemplate);

      outputTemplate();
   }

   private String storyBadge1() {
      return "story-badge-" + 1;
   }

   private StorySummaryTemplate story1() {
      final StorySummaryTemplate storySummaryTemplate = theme.storySummaryTemplate();
      storySummaryTemplate.id(1);
      return storySummaryTemplate;
   }

   private StoryHighlightTemplate highlight1() {
      final StoryHighlightTemplate storyHighlightTemplate = theme.storyHighlightTemplate();
      storyHighlightTemplate.id(1);
      storyHighlightTemplate.title(new Title("my story"));
      return storyHighlightTemplate;
   }

   private void outputTemplate() throws IOException, FileNotFoundException, MalformedURLException {
      final File newFile = temporary.newFile();
      try (final PrintWriter writer = new PrintWriter(newFile)) {
         theme.output(todayTemplate, writer);
      }

      beginAt(newFile.toURI().toURL().toString());
   }
}
