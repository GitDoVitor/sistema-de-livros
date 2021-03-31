package com.bts.booksys.repositories;

import com.bts.booksys.models.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
    Exemplar findByIdExemplar(Long id);
}
