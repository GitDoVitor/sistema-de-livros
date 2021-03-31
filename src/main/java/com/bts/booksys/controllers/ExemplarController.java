package com.bts.booksys.controllers;

import com.bts.booksys.models.Atendente;
import com.bts.booksys.models.Exemplar;
import com.bts.booksys.services.AtendenteService;
import com.bts.booksys.services.ExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exemplares")
public class ExemplarController {

    private final ExemplarService exemplarService;

    @Autowired
    public ExemplarController(ExemplarService exemplarService) {
        this.exemplarService = exemplarService;
    }

    @PostMapping
    public ResponseEntity<Exemplar> insereExemplar(@RequestBody Exemplar exemplar) {
        exemplarService.salvaExemplar(exemplar);
        return new ResponseEntity<>(exemplar, null, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Exemplar> listaExemplares() {
        return exemplarService.listaExemplares();
    }

    @GetMapping("/{id}")
    public Exemplar listaExemplarPorId(@PathVariable Long id) {
        return exemplarService.listaExemplarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaExemplarPorId(Long id) {
        exemplarService.deletaExemplarPorId(id);
    }

    @PutMapping
    public ResponseEntity<Exemplar> editaExemplar(@RequestBody Exemplar exemplar) {
        exemplarService.editaExemplar(exemplar);
        return new ResponseEntity<>(exemplar, null, HttpStatus.ACCEPTED);
    }
}
