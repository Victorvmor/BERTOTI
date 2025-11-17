package com.example.demo_filmes;

import org.springframework.data.repository.CrudRepository;

// [ A CORREÇÃO ESTÁ AQUI ]
// 1. Deve ser uma 'interface', não uma 'class'.
// 2. Deve extender 'CrudRepository'.
//
// Ao fazer isso, o Spring Data JPA vai "ver" esta interface
// e criar automaticamente o bean que o seu Controller precisa.
public interface FilmeRepository extends CrudRepository<Filme, Long> {

    // Não precisa de NADA aqui dentro.
    // Só de existir, o Spring já faz a mágica.
}