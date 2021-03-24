package com.bts.booksys.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void salvaCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    public Cliente listaClientePorId(Long id) {
        return clienteRepository.findByIdCliente(id);
    }

    public void deletaClientePorId(Long id) {
        Cliente cliente = clienteRepository.findByIdCliente(id);
        clienteRepository.delete(cliente);
    }

    public Cliente editaCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}