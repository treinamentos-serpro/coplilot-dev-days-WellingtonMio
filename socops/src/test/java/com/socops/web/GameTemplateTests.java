package com.socops.web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Validates the structural contract of the client-side game modes.
 */
class GameTemplateTests {

    private static String gameTemplate;

    @BeforeAll
    static void loadGameTemplate() throws IOException {
        try (InputStream template = GameTemplateTests.class.getResourceAsStream(
                "/templates/game.html")) {
            if (template == null) {
                throw new IOException("game.html template was not found");
            }
            gameTemplate = new String(template.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    @Test
    @DisplayName("Lobby exposes a Scavenger Hunt mode selector")
    void lobbyExposesScavengerHuntMode() {
        assertTrue(gameTemplate.contains("Scavenger Hunt"),
                "Players must be able to start the Scavenger Hunt mode");
    }

    @Test
    @DisplayName("Template contains a dedicated Scavenger Hunt list and progress indicator")
    void templateContainsScavengerHuntSurface() {
        assertTrue(gameTemplate.contains("scavengerView"),
                "Scavenger Hunt needs its own visible view");
        assertTrue(gameTemplate.contains("scavengerList"),
                "Scavenger Hunt prompts must render in a list");
        assertTrue(gameTemplate.contains("scavengerProgress"),
                "Scavenger Hunt must expose progress separately from bingo");
    }

    @Test
    @DisplayName("Scavenger Hunt renders prompt checkboxes from the existing board questions")
    void scavengerHuntRendersPromptCheckboxes() {
        assertTrue(gameTemplate.contains("type = \"checkbox\""),
                "Each Scavenger Hunt prompt must be represented by a checkbox");
        assertTrue(gameTemplate.contains("/api/bingo/fresh-board"),
                "Scavenger Hunt must reuse the existing prompt source");
        assertTrue(gameTemplate.contains("tile.prompt"),
                "Scavenger Hunt items must use the board prompt text");
    }

    @Test
    @DisplayName("Scavenger Hunt progress is recalculated when a checkbox changes")
    void scavengerHuntUpdatesProgressOnCheck() {
        assertTrue(gameTemplate.contains("addEventListener(\"change\""),
                "Checking an item must trigger a progress update");
        assertTrue(gameTemplate.contains("/ 24"),
                "Progress must count the 24 shared icebreaker questions");
        assertTrue(gameTemplate.contains("aria-live=\"polite\""),
                "Progress changes must be announced to assistive technology");
        assertTrue(gameTemplate.contains("aria-atomic=\"true\""),
                "Progress announcements must include the complete value");
    }
}