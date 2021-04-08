package com.bts.booksys.controllers;

import com.bts.booksys.services.EmprestimoService;
import com.bts.booksys.models.Emprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public ResponseEntity<Emprestimo> insereEmprestimo(@RequestBody Emprestimo emprestimo) throws Exception{
        emprestimoService.salvaEmprestimo(emprestimo);
        return new ResponseEntity<>(emprestimo, null, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Emprestimo> listaEmprestimos() {
        return emprestimoService.listaEmprestimos();
    }

    @GetMapping("/{id}")
    public Emprestimo listaEmprestimoPorId(@PathVariable Long id) {
        return emprestimoService.listaEmprestimoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaEmprestimoPorId(Long id) {
        emprestimoService.deletaEmprestimoPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> editaEmprestimo(@RequestBody Emprestimo emprestimo) {
        emprestimoService.editaEmprestimo(emprestimo);
        return new ResponseEntity<>(emprestimo, null, HttpStatus.ACCEPTED);
    }

    @PutMapping("/cancelar/{id}")
    public void cancelaEmprestimoPorId(@PathVariable Long id) throws Exception {
        emprestimoService.cancelaEmprestimoPorId(id);
    }
}
