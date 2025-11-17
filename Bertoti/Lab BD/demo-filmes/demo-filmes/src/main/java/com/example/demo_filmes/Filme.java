package com.example.demo_filmes;

// 1. Importe as anotações do Jakarta Persistence (JPA)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 2. Diz que esta classe é uma tabela no banco
public class Filme {

    @Id // 3. Diz que este campo é a Chave Primária (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Diz ao banco para gerar o ID automaticamente
    private Long id;

    private String titulo;
    private String diretor;
    private Integer anoLancamento;
    private String genero;

    // 5. O construtor vazio é OBRIGATÓRIO para o JPA
    public Filme() {}

    // O construtor com dados não é mais necessário (vamos apagar o do controller)

    // --- Getters e Setters (Exatamente os mesmos de antes) ---
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