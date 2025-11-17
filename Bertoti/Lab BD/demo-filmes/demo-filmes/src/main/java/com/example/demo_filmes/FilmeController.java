package com.example.demo_filmes;

import org.springframework.beans.factory.annotation.Autowired; // Importante
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Continua usando List
import java.util.Optional;
// import java.util.ArrayList; // Não precisamos mais
// import java.util.concurrent.atomic.AtomicLong; // Não precisamos mais

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    // 1. Apagamos a 'ArrayList' e o 'AtomicLong'
    // 2. Injetamos o Repository
    @Autowired
    private com.example.demo_filmes.FilmeRepository repository;

    // 3. Apagamos o Construtor com dados falsos
    //    Os dados agora são permanentes no banco!

    // --- Endpoints do CRUD (Agora usam o 'repository') ---

    // 1. GET (Listar todos)
    @GetMapping
    public List<Filme> getFilmes() {
        // O repository.findAll() faz um "SELECT * FROM FILME"
        return (List<Filme>) repository.findAll();
    }

    // 2. GET (Buscar por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Filme> getFilmeById(@PathVariable Long id) {
        // O repository.findById() faz um "SELECT * FROM FILME WHERE ID = ?"
        Optional<Filme> filme = repository.findById(id);

        return filme.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. POST (Criar novo)
    @PostMapping
    public ResponseEntity<Filme> postFilme(@RequestBody Filme filme) {
        // O repository.save() faz um "INSERT INTO FILME ..."
        // e já retorna o objeto salvo com o ID gerado pelo banco
        Filme filmeSalvo = repository.save(filme);

        return ResponseEntity.status(HttpStatus.CREATED).body(filmeSalvo);
    }

    // 4. PUT (Atualizar)
    @PutMapping("/{id}")
    public ResponseEntity<Filme> putFilme(@PathVariable Long id, @RequestBody Filme filmeAtualizado) {

        // 1. Tenta buscar o filme no banco
        return repository.findById(id)
                .map(filmeExistente -> {
                    // 2. Se achou, atualiza os dados na memória
                    filmeExistente.setTitulo(filmeAtualizado.getTitulo());
                    filmeExistente.setDiretor(filmeAtualizado.getDiretor());
                    filmeExistente.setAnoLancamento(filmeAtualizado.getAnoLancamento());
                    filmeExistente.setGenero(filmeAtualizado.getGenero());

                    // 3. Salva as mudanças no banco (faz um "UPDATE")
                    Filme filmeSalvo = repository.save(filmeExistente);
                    return ResponseEntity.ok(filmeSalvo);
                })
                // 4. Se não achou (findById retornou vazio), retorna 404
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. DELETE (Apagar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Long id) {
        // Primeiro, verificamos se o ID existe
        if (repository.existsById(id)) {
            // Se existe, o repository.deleteById() faz um "DELETE FROM FILME WHERE ID = ?"
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            // Se não existe, retorna 404
            return ResponseEntity.notFound().build();
        }
    }
}