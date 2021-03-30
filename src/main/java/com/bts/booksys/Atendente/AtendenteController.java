package com.bts.booksys.Atendente;

import com.bts.booksys.Cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendente")
public class AtendenteController {

    private final AtendenteService atendenteService;

    @Autowired
    public AtendenteController(AtendenteService atendenteService) {
        this.atendenteService = atendenteService;
    }

    @PostMapping
    public ResponseEntity<?> insereAtendente(@RequestBody Atendente atendente) {
        atendenteService.salvaAtendente(atendente);
        return new ResponseEntity<>(atendente, null, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Atendente> listaAtendentes() {
        return atendenteService.listaAtendentes();
    }

    @GetMapping("/{id}")
    public Atendente listaAtendentePorId(@PathVariable Long id) {
        return atendenteService.listaAtendentePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaAtendentePorId(Long id) {
        atendenteService.deletaAtendentePorId(id);
    }

    @PutMapping
    public ResponseEntity<?> editaAtendente(@RequestBody Atendente atendente) {
        atendenteService.editaAtendente(atendente);
        return new ResponseEntity<>(atendente, null, HttpStatus.ACCEPTED);
    }
}
