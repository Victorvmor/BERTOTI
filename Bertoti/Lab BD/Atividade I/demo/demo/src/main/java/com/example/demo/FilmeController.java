package com.example.demo;

// Imports do Spring Web para criar o Controller
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Imports do Java para lidar com listas e IDs
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // Diz ao Spring que esta classe vai controlar URLs de API
@RequestMapping("/filmes") // Todas as URLs aqui dentro começam com http://localhost:8080/filmes
public class FilmeController {

    // ETAPA 1: Lista em memória.
    // (Na Etapa 2, vamos substituir isso pelo Repository)
    private List<Filme> filmes = new ArrayList<>();

    // Construtor: Vamos adicionar alguns filmes "falsos" para a lista ter algo
    public FilmeController() {
        filmes.addAll(List.of(
                new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972, "Crime"),
                new Filme("Interestelar", "Christopher Nolan", 2014, "Sci-Fi"),
                new Filme("Parasita", "Bong Joon-ho", 2019, "Suspense"),
                new Filme("Cidade de Deus", "Fernando Meirelles", 2002, "Crime")
        ));
    }




    @GetMapping
    public List<Filme> getFilmes() {
        return filmes;
    }

    @GetMapping("/{id}")
    public Optional<Filme> getFilmeById(@PathVariable String id) {
        // Procura na lista um filme que tenha o ID igual ao da URL
        return filmes.stream()
                .filter(filme -> filme.getId().equals(id))
                .findFirst();
    }


    @PostMapping
    public Filme postFilme(@RequestBody Filme filme) {
        // @RequestBody transforma o JSON que o Postman envia em um objeto Filme
        filmes.add(filme);
        return filme;
    }

    // 4. DELETE (Deletar)
    // URL: DELETE http://localhost:8080/filmes/ALGUM_ID
    @DeleteMapping("/{id}")
    public void deleteFilme(@PathVariable String id) {
        // Remove da lista o filme com o ID correspondente
        filmes.removeIf(filme -> filme.getId().equals(id));
    }

    // 5. PUT (Atualizar)
    // URL: PUT http://localhost:8080/filmes/ALGUM_ID
    // (Enviando o JSON com os novos dados no Body)
    @PutMapping("/{id}")
    public ResponseEntity<Filme> putFilme(@PathVariable String id, @RequestBody Filme filmeAtualizado) {
        int indiceFilme = -1;

        // Tenta achar o índice do filme na lista
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId().equals(id)) {
                indiceFilme = i;
                break;
            }
        }

        if (indiceFilme == -1) {
            // Se não achou, retorna um erro 404 (Not Found)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Se achou, atualiza o filme na lista e retorna 200 (OK)
        filmes.set(indiceFilme, filmeAtualizado);
        return ResponseEntity.ok(filmeAtualizado);
    }
}