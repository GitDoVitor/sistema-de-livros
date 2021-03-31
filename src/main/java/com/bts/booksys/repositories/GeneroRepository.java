package com.bts.booksys.repositories;

import com.bts.booksys.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Genero findByIdGenero(Long id);
}
