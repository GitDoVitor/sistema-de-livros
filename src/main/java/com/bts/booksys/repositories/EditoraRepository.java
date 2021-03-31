package com.bts.booksys.repositories;

import com.bts.booksys.models.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
    Editora findByIdEditora(Long id);
}
