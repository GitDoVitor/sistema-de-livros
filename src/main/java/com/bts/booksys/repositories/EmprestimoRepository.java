package com.bts.booksys.repositories;

import com.bts.booksys.models.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    Emprestimo findByIdEmprestimo(Long id);
}
