package com.bts.booksys.repositories;

import com.bts.booksys.models.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
    Atendente findByIdAtendente(Long id);
}
