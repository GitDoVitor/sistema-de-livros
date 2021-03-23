package com.bts.booksys.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<?> insereCliente(@RequestBody Cliente cliente) {
        clienteService.salvaCliente(cliente);
        return new ResponseEntity<>(cliente, null, HttpStatus.CREATED);
    }

    @GetMapping
    public List<?> listaClientes() {
        return clienteService.listaClientes();
    }

    @GetMapping("/{id}")
    public Cliente listaClientePorId(@PathVariable Long id) {
        return clienteService.listaClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaClientePorId(Long id) {
        clienteService.deletaClientePorId(id);
    }

    @PutMapping
    public ResponseEntity<?> editaCliente(@RequestBody Cliente cliente) {
        clienteService.editaCliente(cliente);
        return new ResponseEntity<>(cliente, null, HttpStatus.ACCEPTED);
    }
}
