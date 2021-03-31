package com.bts.booksys.controllers;

import com.bts.booksys.services.EditoraService;
import com.bts.booksys.models.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PostMapping
    Editora criaEditora(@RequestBody Editora editora) {
        return editoraService.salvaEditora(editora);
    }
}
