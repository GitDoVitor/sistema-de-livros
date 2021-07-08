package com.bts.booksys.controllers;

import com.bts.booksys.models.Exemplar;
import com.bts.booksys.services.ExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/{dataInicial}/{dataFinal}")
    public List<Exemplar> listaExemplaresDisponiveisPorData(@PathVariable(value = "dataInicial")
                                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial , @PathVariable(value = "dataFinal")
                                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal) {
        return exemplarService.listaExemplaresDisponiveisPorData(dataInicial, dataFinal);
    }

    @GetMapping("/{livro}/{dataInicial}/{dataFinal}")
    public List<Exemplar> listaLivroDisponiveisPorData(@PathVariable String livro, @PathVariable(value = "dataInicial")
                                                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial , @PathVariable(value = "dataFinal")
                                                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal) {
        return exemplarService.listaLivroDisponivelPorData(livro, dataInicial, dataFinal);
    }

    @GetMapping("/{id}")
    public Exemplar listaExemplarPorId(@PathVariable Long id) {
        return exemplarService.listaExemplarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaExemplarPorId(@PathVariable Long id) {
        exemplarService.deletaExemplarPorId(id);
    }

    @GetMapping("/livro/{titulo}")
    public List<Exemplar> listaExemplaresPorTituloDeLivro(@PathVariable String titulo) {
        return exemplarService.listaExemplaresPorTituloDeLivro(titulo);
    }

    @PutMapping
    public ResponseEntity<Exemplar> editaExemplar(@RequestBody Exemplar exemplar) {
        exemplarService.editaExemplar(exemplar);
        return new ResponseEntity<>(exemplar, null, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<Exemplar> listaTodosExemplares() {
        return exemplarService.listaTodosExemplares();
    }
}
