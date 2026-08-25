package com.socops.data;

import java.util.List;

/**
 * Central catalogue of every icebreaker prompt that can appear on a board.
 * Exactly 24 entries — one fewer than the 25-cell grid, because the
 * centre cell is always the free space.
 */
public final class IcebreakerPrompts {

    public static final String FREE_CELL_LABEL = "ESPAÇO LIVRE";

    public static final List<String> ALL_PROMPTS = List.of(
            "Qual foi uma pequena vitória sua nesta semana?",
            "Que habilidade você gostaria de desenvolver este ano?",
            "Compartilhe algo que aprendeu recentemente.",
            "O que ajuda você a começar bem o dia?",
            "Qual lugar desperta boas lembranças para você?",
            "Mostre um objeto que tenha significado para você.",
            "Que conselho você daria para a sua versão de um ano atrás?",
            "Qual atividade faz você perder a noção do tempo?",
            "Conte sobre uma gentileza que marcou seu dia.",
            "Que música costuma melhorar seu humor?",
            "Qual foi um desafio que ensinou algo valioso a você?",
            "Compartilhe uma tradição de que você gosta.",
            "Ensine um truque rápido que você sabe fazer.",
            "O que você valoriza em uma boa colaboração?",
            "Qual pessoa inspirou você profissionalmente?",
            "Que projeto ou tarefa recente deixou você orgulhoso?",
            "O que você faz para recarregar as energias?",
            "Compartilhe um livro, filme ou podcast que recomenda.",
            "Que pergunta você gostaria que fizessem mais a você?",
            "Qual foi uma mudança positiva que você viveu recentemente?",
            "Jogue pedra, papel ou tesoura com alguém.",
            "Qual curiosidade sobre você costuma surpreender as pessoas?",
            "Em que momento você se sente mais criativo?",
            "Compartilhe algo pelo qual você é grato hoje."
    );

    private IcebreakerPrompts() {
        /* catalogue only — no instances */
    }
}
