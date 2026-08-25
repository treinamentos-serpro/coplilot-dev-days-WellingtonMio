🌐 [Português (BR)](README.pt_BR.md) | [Español](README.es.md)

# Soc Ops

A social bingo game lab for in-person events, built to teach **context engineering** and **multi-agent workflows** with GitHub Copilot.

🎯 Build, play, and learn by shipping a real app: collect 5 in a row by finding people who match each icebreaker prompt.

📚 **[Start the Lab Guide](workshop/GUIDE.md)**

---

## ✨ Why this project is worth your time

- Learn practical GitHub Copilot workflows beyond autocomplete
- Practice design-first implementation with a real UI
- Use custom agents (Quiz Master + TDD agents) in guided exercises
- End with a deployable Spring Boot app published to GitHub Pages

## 🚀 Jump in quickly

```bash
cd socops
./mvnw spring-boot:run
```

Then open **http://localhost:8080**.

---

## 🧭 Lab roadmap

| Part | Title |
|------|-------|
| [**00**](workshop/00-overview.md) | Overview & Checklist |
| [**01**](workshop/01-setup.md) | Setup & Context Engineering |
| [**02**](workshop/02-design.md) | Design-First Frontend |
| [**03**](workshop/03-quiz-master.md) | Custom Quiz Master |
| [**04**](workshop/04-multi-agent.md) | Multi-Agent Development |

> 📝 Lab guides are also available in the [`workshop/`](workshop/) folder for offline reading.

---

## 🛠️ Prerequisites

- [Java 21 JDK](https://adoptium.net/) or higher
- [Apache Maven 3.9+](https://maven.apache.org/) (or use the included Maven Wrapper)

## ▶️ Run

```bash
cd socops
./mvnw spring-boot:run
```

## 📦 Build

```bash
cd socops
./mvnw clean package
```

## ✅ Test

```bash
cd socops
./mvnw test
```

## 🧱 What’s inside

- **Backend:** Spring Boot 3 + Java 21
- **Frontend:** Thymeleaf + Vanilla JavaScript
- **Core game logic:** 5×5 bingo board with immutable center free-space
- **Workshop content:** step-by-step docs in `workshop/`

## 🌍 Deployment

This project deploys automatically to GitHub Pages on push to `main`.
See [`.github/workflows/deploy.yml`](.github/workflows/deploy.yml) if you want to adapt deployment for your own fork.
