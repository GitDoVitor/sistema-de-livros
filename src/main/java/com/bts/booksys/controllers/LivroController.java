package com.bts.booksys.controllers;

import com.bts.booksys.services.LivroService;
import com.bts.booksys.models.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/livros")
public class LivroController {
    final
    LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    List<Livro> listaTodosLivros() {
        return livroService.listaTodos();
    }

    @GetMapping("/titulo/{titulo}")
    List<Livro> listaTodosPeloTitulo(@PathVariable String titulo) {
        return livroService.listaTodosPorTitulo(titulo);
    }

    @GetMapping("/genero/{genero}")
    List<Livro> listaTodosPeloGenero(@PathVariable String genero) {
        return livroService.listaTodosPorGenero(genero);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> listaPorId(@PathVariable Long id) {
        Optional<Livro> livro = livroService.listaPorID(id);
        return new ResponseEntity<>(livro, HttpStatus.FOUND);
    }

    @PostMapping
    ResponseEntity<?> criaUmLivro(@RequestBody Livro livro) {
        livroService.criaUm(livro);
        return new ResponseEntity<>(livro, null, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    void apagaUmLivro(@PathVariable Long id) {
        livroService.apagaUm(id);
    }


}
