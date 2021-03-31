package com.bts.booksys.repositories;

import com.bts.booksys.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByIdCliente(Long id);
}
