package com.example.demo;

import java.util.UUID;

public class Filme {

    // Na Etapa 1, vamos usar um ID de texto (UUID),
    // igual seu colega fez na Atividade I.
    private final String id;

    // Nossos campos personalizados
    private String titulo;
    private String diretor;
    private Integer anoLancamento;
    private String genero;

    // --- Construtores ---

    // Construtor que gera um ID aleatório automaticamente
    public Filme(String titulo, String diretor, Integer anoLancamento, String genero) {
        this(UUID.randomUUID().toString(), titulo, diretor, anoLancamento, genero);
    }

    // Construtor principal que recebe o ID
    public Filme(String id, String titulo, String diretor, Integer anoLancamento, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    // --- Getters e Setters ---
    // O Spring precisa deles para ler e escrever os dados (ex: no JSON)

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}