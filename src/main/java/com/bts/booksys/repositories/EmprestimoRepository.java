package com.bts.booksys.repositories;

import com.bts.booksys.models.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    Emprestimo findByIdEmprestimo(Long id);

//    @Query("SELECT * FROM Emprestimos")
//    List<Emprestimo>

}
