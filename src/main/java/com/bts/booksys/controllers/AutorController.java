package com.bts.booksys.controllers;

import com.bts.booksys.services.AutorService;
import com.bts.booksys.models.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/autores")
public class AutorController {
    final
    AutorService autorService;
    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }


    @PostMapping
    public ResponseEntity<Autor> insereAutor(@RequestBody Autor autor) {
        autorService.salvaAutor(autor);
        return new ResponseEntity<>(autor, null, HttpStatus.CREATED);
    }


    @GetMapping
    public List<?> listaAutores() {
        return autorService.listaAutores();
    }


    @GetMapping("/{id}")
    public Autor listaAutorPorId(@PathVariable Long id) {
        return autorService.listaAutorPorId(id);
    }


    @DeleteMapping("/{id}")
    public void deletaAutorPorId(@PathVariable Long id) {
        autorService.deletaAutorPorId(id);
    }


    @PutMapping("/{id}")
    public void editaAutor(@PathVariable Long id, String nome) {
        autorService.editaAutor(id, nome);
    }

}
