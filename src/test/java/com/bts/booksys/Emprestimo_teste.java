package com.bts.booksys;

import com.bts.booksys.models.Emprestimo;
import com.bts.booksys.services.EmprestimoService;
import com.bts.booksys.enums.StatusEmprestimo;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Emprestimo_teste {

    @Autowired
    EmprestimoService emprestimoService;

    @Test
    @Order(2)
    void insereEmprestimo() {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataInicial(LocalDate.now());
        emprestimo.setDataFinal(LocalDate.now());
        emprestimo.setStatus(StatusEmprestimo.EM_ANDAMENTO);
        emprestimo.setValorTotal(400.00);

        Emprestimo emprestimoSalvo = emprestimoService.salvaEmprestimo(emprestimo);
        Assertions.assertEquals(emprestimo, emprestimoSalvo);
    }

    @Test
    @Order(1)
    void listaEmprestimos() {
        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setDataInicial(LocalDate.now());
        emprestimo1.setDataFinal(LocalDate.now());
        emprestimo1.setStatus(StatusEmprestimo.EM_ANDAMENTO);
        emprestimo1.setValorTotal(400.00);

        Emprestimo emprestimo2 = new Emprestimo();
        emprestimo2.setDataInicial(LocalDate.now());
        emprestimo2.setDataFinal(LocalDate.now());
        emprestimo2.setStatus(StatusEmprestimo.CANCELADO);
        emprestimo2.setValorTotal(300.00);

        emprestimoService.salvaEmprestimo(emprestimo1);
        emprestimoService.salvaEmprestimo(emprestimo2);

        List<Emprestimo> emprestimosModelo = new ArrayList<Emprestimo>();
        emprestimosModelo.add(emprestimo1);
        emprestimosModelo.add(emprestimo2);

        List<Emprestimo> emprestimosListados = emprestimoService.listaEmprestimos();
         Assertions.assertEquals(emprestimosModelo.size(), emprestimosListados.size());
    }

    @Test
    @Order(3)
    void listaEmprestimoPorId() {
        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setIdEmprestimo(1L);
        emprestimo1.setDataInicial(LocalDate.now());
        emprestimo1.setDataFinal(LocalDate.now());
        emprestimo1.setStatus(StatusEmprestimo.EM_ANDAMENTO);
        emprestimo1.setValorTotal(400.00);

        Emprestimo emprestimo2 = new Emprestimo();
        emprestimo2.setIdEmprestimo(2L);
        emprestimo2.setDataInicial(LocalDate.now());
        emprestimo2.setDataFinal(LocalDate.now());
        emprestimo2.setStatus(StatusEmprestimo.CANCELADO);
        emprestimo2.setValorTotal(300.00);

        emprestimoService.salvaEmprestimo(emprestimo1);
        emprestimoService.salvaEmprestimo(emprestimo2);

        Emprestimo emprestimoComId2 = emprestimoService.listaEmprestimoPorId(2L);
        Assertions.assertNotNull(emprestimoComId2);
    }

    @Test
    @Order(4)
    void cancelaEmprestimo() throws Exception {
        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setIdEmprestimo(1L);
        emprestimo1.setDataInicial(LocalDate.now());
        emprestimo1.setDataFinal(LocalDate.of(2021, 9,9));
        emprestimo1.setStatus(StatusEmprestimo.EM_ANDAMENTO);
        emprestimo1.setValorTotal(400.00);

        emprestimoService.salvaEmprestimo(emprestimo1);
        Emprestimo emprestimoCancelado = emprestimoService.cancelaEmprestimoPorId(1L);

        Assertions.assertEquals(emprestimoCancelado.getStatus(), StatusEmprestimo.CANCELADO);
    }
}
