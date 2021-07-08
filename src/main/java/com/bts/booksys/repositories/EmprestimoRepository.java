package com.bts.booksys.repositories;

import com.bts.booksys.models.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    Emprestimo findByIdEmprestimo(Long id);
    List<Emprestimo> findAllByExemplar_Livro_titulo(String nome);
    @Query("select s from Emprestimo s where s.status=0")
    List<Emprestimo> findAllByStatus_Reservado();
    @Query("select s from Emprestimo s where s.status=2")
    List<Emprestimo> findAllByStatus_Realizado();
    @Query("select s from Emprestimo s where s.status=3")
    List<Emprestimo> findAllByStatus_Cancelado();
    @Query("select s from Emprestimo s where s.status=1")
    List<Emprestimo> findAllByStatus_Andamento();
}
