package com.bts.booksys.controllers;

import com.bts.booksys.services.GeneroService;
import com.bts.booksys.models.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/generos")
public class GeneroController {

    final
    GeneroService generoService;

    @Autowired
    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PostMapping
    public ResponseEntity<Genero> insereGenero(@RequestBody Genero genero) {
        generoService.salvaGenero(genero);
        return new ResponseEntity<>(genero, null, HttpStatus.CREATED);
    }

    @GetMapping
    public List<?> listaGeneros() {
        return generoService.listaGeneros();
    }

    @GetMapping("/{id}")
    public Genero listaGeneroPorId(@PathVariable Long id) {
        return generoService.listaGeneroPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaGeneroPorId(@PathVariable Long id) {
        generoService.deletaGeneroPorId(id);
    }

}
