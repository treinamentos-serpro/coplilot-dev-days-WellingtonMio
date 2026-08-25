---
name: Soc Ops Agent Instructions
description: Context for AI agents working on Soc Ops — a Social Bingo game lab for GitHub Copilot.
---

# Soc Ops — Agent Instructions

## ✅ Before Any Commit

**MANDATORY CHECKLIST** — Always run these before committing changes:
```bash
cd socops && ./mvnw clean              # Clean build
cd socops && ./mvnw test               # Run tests (JUnit 5)
cd socops && ./mvnw spring-boot:run    # Verify runs locally
```

---

**Soc Ops** is an educational social bingo game (Spring Boot 3.4.2 + Java 21 + Thymeleaf + Vanilla JS) for learning context engineering, custom agents, and multi-agent workflows via GitHub Copilot.

## 🎮 Quick Overview

- **Game**: 5×5 bingo grid with icebreaker prompts (center = FREE SPACE, index 12)
- **Backend**: `BingoRestController` → `GET /api/bingo/fresh-board` returns 25 `BingoCell` records
- **Service**: `BoardAssembler` (pure static logic — board creation, cell flipping, victory detection)
- **Frontend**: Single-page Thymeleaf template with vanilla JS, localStorage persistence (`socops-bingo-snapshot`)
- **State Machine**: LOBBY → ACTIVE → VICTORY (client-side game engine)
- **Styling**: Custom utility CSS in `app.css` (no external frameworks)

## 🏗️ Key Files

| Path | Purpose |
|------|---------|
| `socops/src/main/java/com/socops/web/BingoRestController.java` | Routes: `/` (lobby), `/api/bingo/fresh-board` (board JSON) |
| `socops/src/main/java/com/socops/service/BoardAssembler.java` | Pure logic: board assembly, cell toggle, victory streaks (tested in isolation) |
| `socops/src/main/resources/templates/game.html` | Single-page game UI + vanilla JS engine |
| `socops/src/main/resources/static/css/app.css` | Utility classes (flexbox, grid, spacing, colors, animation) |
| `socops/src/main/java/com/socops/data/IcebreakerPrompts.java` | List of 24 icebreaker prompts (shuffled per board) |

## 📋 Conventions

- **Java**: Spring idioms, records for models, static utility methods, JUnit 5 tests
- **Frontend**: Vanilla JS only (no frameworks), state persisted to localStorage
- **CSS**: Utility-first custom classes; add to `app.css` following existing patterns
- **Game Flow**: Always update both JS state AND localStorage on phase changes
- **Free Cell**: Index 12 is immutable—never toggle, always pre-selected

## 🎨 Design Guide — Desert Sand Minimal

- **Visual direction**: Keep the interface calm, tactile, and editorial. Use sand and clay tones as the foundation, charcoal for structure, and blue-green only as a restrained functional contrast.
- **Color tokens**: Define shared colors as CSS variables in `app.css`. Prefer the existing palette (`--paper`, `--paper-deep`, `--ink`, `--muted`, `--line`, `--sage`, `--sage-deep`, `--warm`) over introducing isolated hex values.
- **Layout**: Let the 5×5 board remain the primary visual element. Use generous whitespace, thin separators, small uppercase metadata, and a controlled maximum width. Avoid card-within-card layouts and unnecessary decoration.
- **Typography**: Use a readable sans-serif for controls and metadata, paired with a restrained serif for display headings. Keep letter spacing at zero for normal text and reserve tracking for small uppercase labels.
- **Interaction states**: Make unselected, selected, free, and winning cells visually distinct while preserving contrast and square dimensions. Keep keyboard focus visible and retain `aria-pressed` and `aria-label` attributes on board buttons.
- **Motion**: Use subtle transitions and one restrained reveal animation. Always provide a `prefers-reduced-motion` fallback.
- **Responsive behavior**: Design for narrow screens first. Cells must remain square, prompts must wrap without overflow, and controls must remain tappable without shifting the board.
- **Scope**: Keep the design dependency-free: Thymeleaf, vanilla JavaScript, and custom CSS only. Preserve the existing IDs, state machine, localStorage key, endpoint, and bingo rules when changing presentation.

## 🎯 Agent Workflows

1. **Part 1 — Context Engineering**: `/setup` documents codebase
2. **Part 2 — Design-First**: UI redesign with [frontend design guidelines](/.github/instructions/frontend-design.instructions.md)
3. **Part 3 — Quiz Master**: Generate themed icebreaker prompts
4. **Part 4 — Multi-Agent**: TDD (Red → Green → Refactor) + Pixel Jam for features
5. **Part 5 — Complete**: Deploy to GitHub Pages

## 🛠️ Which Agent for What?

| Agent | Use for |
|-------|---------|
| **Quiz Master** | Theme generation, prompt creation, creative brainstorming |
| **Pixel Jam** | UI/UX design, styling, visual polish |
| **TDD Red/Green/Refactor** | Test-first feature development |
| **UI Review** | Design validation & polish |

## ⚠️ Critical Rules

1. **CSS**: No external Tailwind—utilities only. Add to `app.css`.
2. **State**: Update both JS vars AND localStorage (`persistSnapshot()`)
3. **Victory**: `WinningStreak` computed server-side; JS only highlights
4. **Design**: Avoid generic AI aesthetics; be creative & distinctive

## 📚 Docs

[Lab Guide](workshop/GUIDE.md) • [CSS Utilities](/.github/instructions/css-utilities.instructions.md) • [Frontend Design](/.github/instructions/frontend-design.instructions.md) • [Live Demo](https://copilot-dev-days.github.io/agent-lab-java/)
