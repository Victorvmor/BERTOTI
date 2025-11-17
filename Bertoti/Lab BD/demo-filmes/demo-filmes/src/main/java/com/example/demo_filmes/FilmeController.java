package com.example.demo_filmes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // <-- TEM QUE TER ESSES IMPORTS

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController // <-- 1. VERIFIQUE ISSO! Sem isso, não é um controlador REST.
@RequestMapping("/filmes") // <-- 2. VERIFIQUE ISSO! Sem isso, ele não sabe a URL.
public class FilmeController {

    // 1. A Lista em memória que funciona como "banco de dados falso"
    private final List<com.example.demofilmes.Filme> filmes = new ArrayList<>();

    // 2. Um gerador de IDs
    private final AtomicLong contadorId = new AtomicLong();

    // 3. Construtor para popular com dados falsos
    public FilmeController() {
        filmes.add(new com.example.demofilmes.Filme(contadorId.incrementAndGet(), "Matrix", "Wachowski", 1999, "Ficção Científica"));
        filmes.add(new com.example.demofilmes.Filme(contadorId.incrementAndGet(), "Poderoso Chefão", "Coppola", 1972, "Drama"));
        filmes.add(new com.example.demofilmes.Filme(contadorId.incrementAndGet(), "Interestelar", "Nolan", 2014, "Ficção Científica"));
    }

    // 1. GET (Listar todos)
    @GetMapping // <-- 3. VERIFIQUE AS ANOTAÇÕES DOS MÉTODOS
    public List<com.example.demofilmes.Filme> getFilmes() {
        return filmes;
    }

    // 2. GET (Buscar por ID)
    @GetMapping("/{id}")
    public ResponseEntity<com.example.demofilmes.Filme> getFilmeById(@PathVariable Long id) {
        Optional<com.example.demofilmes.Filme> filme = filmes.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        return filme.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ... (o resto dos métodos @PostMapping, @PutMapping, @DeleteMapping) ...
    // ... eles também precisam das anotações corretas ...

    // 3. POST (Criar novo)
    @PostMapping
    public ResponseEntity<com.example.demofilmes.Filme> postFilme(@RequestBody com.example.demofilmes.Filme filme) {
        filme.setId(contadorId.incrementAndGet());
        filmes.add(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);
    }

    // 4. PUT (Atualizar)
    @PutMapping("/{id}")
    public ResponseEntity<com.example.demofilmes.Filme> putFilme(@PathVariable Long id, @RequestBody com.example.demofilmes.Filme filmeAtualizado) {
        Optional<com.example.demofilmes.Filme> filmeExistenteOpt = filmes.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        if (filmeExistenteOpt.isPresent()) {
            com.example.demofilmes.Filme filmeExistente = filmeExistenteOpt.get();
            filmeExistente.setTitulo(filmeAtualizado.getTitulo());
            filmeExistente.setDiretor(filmeAtualizado.getDiretor());
            filmeExistente.setAnoLancamento(filmeAtualizado.getAnoLancamento());
            filmeExistente.setGenero(filmeAtualizado.getGenero());

            return ResponseEntity.ok(filmeExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. DELETE (Apagar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Long id) {
        boolean removeu = filmes.removeIf(f -> f.getId().equals(id));

        if (removeu) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}