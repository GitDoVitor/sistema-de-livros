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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/reserva")
    public ResponseEntity<Emprestimo> reservaEmprestimo(@RequestBody Emprestimo emprestimo) throws Exception{
        emprestimoService.reservaEmprestimo(emprestimo);
        return new ResponseEntity<>(emprestimo, null, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Emprestimo> listaEmprestimos() {
        return emprestimoService.listaEmprestimos();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Emprestimo listaEmprestimoPorId(@PathVariable Long id) {
        return emprestimoService.listaEmprestimoPorId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/livro/{nome}")
    public List<Emprestimo> listaEmprestimosPorLivro(@PathVariable String nome) {
        return emprestimoService.listaEmprestimosPorLivro(nome);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public void deletaEmprestimoPorId(@PathVariable Long id) {
        emprestimoService.deletaEmprestimoPorId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping
    public ResponseEntity<?> editaEmprestimo(@RequestBody Emprestimo emprestimo) {
        emprestimoService.editaEmprestimo(emprestimo);
        return new ResponseEntity<>(emprestimo, null, HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/cancelar/{id}")
    public void cancelaEmprestimoPorId(@PathVariable Long id) throws Exception {
        emprestimoService.cancelaEmprestimoPorId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/iniciar/{id}")
    public void iniciaEmprestimoPorId(@PathVariable Long id) throws Exception {
        emprestimoService.iniciaEmprestimoPorId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/renovar/{id}/{dataFinal}")
    public void renovaEmprestimoPorId(@PathVariable Long id, @PathVariable(value = "dataFinal")
    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal) throws Exception {
        emprestimoService.renovaEmprestimoPorId(id, dataFinal);
    }
}
