package com.example.demofilmes;

public class Filme {

    private Long id;
    private String titulo;
    private String diretor;
    private Integer anoLancamento;
    private String genero;

    // Construtor vazio (boa prática)
    public Filme() {}

    // Construtor para facilitar a criação de dados falsos
    public Filme(Long id, String titulo, String diretor, Integer anoLancamento, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    // --- Getters e Setters (Necessários para o Spring) ---
    // (Você pode gerar na IDE com Alt+Insert -> Getters and Setters)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDiretor() { return diretor; }
    public void setDiretor(String diretor) { this.diretor = diretor; }
    public Integer getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(Integer anoLancamento) { this.anoLancamento = anoLancamento; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}