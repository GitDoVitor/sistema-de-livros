package com.bts.booksys.services;

import com.bts.booksys.models.Cliente;
import com.bts.booksys.repositories.ClienteRepository;
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

    public Cliente salvaCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
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
