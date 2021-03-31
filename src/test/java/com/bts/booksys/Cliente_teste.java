package com.bts.booksys;

import com.bts.booksys.models.Cliente;
import com.bts.booksys.services.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Cliente_teste {

    @Autowired
    ClienteService clienteService;

    @Test
    void insereCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Jose1");
        cliente.setEmail("gmail@gmail.com");
        cliente.setTelefone("4848-3232");

        Cliente clienteSalvo = clienteService.salvaCliente(cliente);
        Assertions.assertEquals(cliente, clienteSalvo);
    }

    @Test
    void listaClientes() {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Jose");
        cliente1.setEmail("gmail@gmail.com");
        cliente1.setTelefone("4848-3232");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria");
        cliente2.setEmail("gmail2@gmail.com");
        cliente2.setTelefone("3232-4848");

        clienteService.salvaCliente(cliente1);
        clienteService.salvaCliente(cliente2);

        List<Cliente> clientesModelo = new ArrayList<Cliente>();
        clientesModelo.add(cliente1);
        clientesModelo.add(cliente2);

        List<Cliente> clientesListados = clienteService.listaClientes();
        Assertions.assertEquals(clientesModelo.size(), clientesListados.size());
    }

    @Test
    void listaClientePorId() {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Jose2");
        cliente1.setEmail("gmail@gmail.com");
        cliente1.setTelefone("4848-3232");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria1");
        cliente2.setEmail("gmail2@gmail.com");
        cliente2.setTelefone("3232-4848");

        clienteService.salvaCliente(cliente1);
        clienteService.salvaCliente(cliente2);

        Cliente clienteComId2 = clienteService.listaClientePorId(2L);
        Assertions.assertNotNull(clienteComId2);
    }

    @Test
    void deletaClientePorId() {
        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setNome("Jose3");
        cliente1.setEmail("gmail@gmail.com");
        cliente1.setTelefone("4848-3232");

        clienteService.salvaCliente(cliente1);
        clienteService.deletaClientePorId(1L);
        Cliente clienteDeletado = clienteService.listaClientePorId(1L);

        Assertions.assertNull(clienteDeletado);
    }

    @Test
    void editaCliente() {
        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setNome("Jose4");
        cliente1.setEmail("gmail@gmail.com");
        cliente1.setTelefone("4848-3232");

        clienteService.salvaCliente(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setIdCliente(1L);
        cliente2.setNome("Maria2");
        cliente2.setEmail("gmail2@gmail.com");
        cliente1.setTelefone("4848-3232");

        Cliente clienteEditado = clienteService.editaCliente(cliente2);
        Cliente clienteSalvo = clienteService.listaClientePorId(1L);

        Assertions.assertEquals(clienteEditado.getNome(), clienteSalvo.getNome());
    }
}
