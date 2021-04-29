package com.bts.booksys.controllers;

import com.bts.booksys.enums.StatusEmprestimo;
import com.bts.booksys.services.EmprestimoService;
import com.bts.booksys.models.Emprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }


    @PostMapping("/reserva")
    public ResponseEntity<Emprestimo> reservaEmprestimo(@RequestBody Emprestimo emprestimo) throws Exception{
        emprestimoService.reservaEmprestimo(emprestimo);
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

    @GetMapping("/livro/{nome}")
    public List<Emprestimo> listaEmprestimosPorLivro(@PathVariable String nome) {
        return emprestimoService.listaEmprestimosPorLivro(nome);
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

    @PutMapping("/iniciar/{id}")
    public void iniciaEmprestimoPorId(@PathVariable Long id) throws Exception {
        emprestimoService.iniciaEmprestimoPorId(id);
    }

    @PutMapping("/renovar/{id}/{dataFinal}")
    public void renovaEmprestimoPorId(@PathVariable Long id, @PathVariable(value = "dataFinal")
    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal) throws Exception {
        emprestimoService.renovaEmprestimoPorId(id, dataFinal);
    }
}
