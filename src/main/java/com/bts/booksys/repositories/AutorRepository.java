package com.bts.booksys.repositories;

import com.bts.booksys.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByIdAutor(Long id);
}
