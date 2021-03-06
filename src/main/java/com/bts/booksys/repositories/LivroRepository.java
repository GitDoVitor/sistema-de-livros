package com.bts.booksys.repositories;

import com.bts.booksys.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findAllByTitulo(String titulo);
    List<Livro> findAllByGenero_Nome(String genero);
}
