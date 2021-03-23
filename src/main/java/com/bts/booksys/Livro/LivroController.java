package com.bts.booksys.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    final
    LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/todos")
    List<Livro> listaTodosLivros() {
        return livroService.listaTodos();
    }

    @GetMapping("/{titulo}")
    List<Livro> listaTodosPeloTitulo(@PathVariable String titulo) {
        return livroService.listaTodosPorTitulo(titulo);
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
