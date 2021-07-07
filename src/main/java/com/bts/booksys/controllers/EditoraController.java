package com.bts.booksys.controllers;

import com.bts.booksys.services.EditoraService;
import com.bts.booksys.models.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/editoras")
public class EditoraController {
    final
    EditoraService editoraService;

    @Autowired
    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    @GetMapping
    List<Editora> mostraTodas() {
        return editoraService.listaEditoras();
    }

    @GetMapping("/{id}")
    Editora listaEditoraPorId(@PathVariable Long id) {
        return editoraService.listaEditoraPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaEditora(@PathVariable Long id) {
        editoraService.deletaEditora(id);
    }

    @PostMapping
    public ResponseEntity<Editora> criaEditora(@RequestBody Editora editora) {
        editoraService.salvaEditora(editora);
        return new ResponseEntity<>(editora, null, HttpStatus.CREATED);
    }
}
