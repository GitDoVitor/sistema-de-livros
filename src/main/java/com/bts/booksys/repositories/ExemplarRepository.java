package com.bts.booksys.repositories;

import com.bts.booksys.enums.StatusExemplar;
import com.bts.booksys.models.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
    Exemplar findByIdExemplar(Long id);
    List<Exemplar> findAllByLivro_titulo(String titulo);
    List<Exemplar> findAllByStatus(StatusExemplar statusExemplar);
}
