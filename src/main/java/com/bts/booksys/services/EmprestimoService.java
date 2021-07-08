package com.bts.booksys.services;

import com.bts.booksys.enums.StatusEmprestimo;
import com.bts.booksys.models.Emprestimo;
import com.bts.booksys.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    @Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public Emprestimo reservaEmprestimo(Emprestimo emprestimo) throws Exception{
        if (emprestimo.getDataFinal().compareTo(emprestimo.getDataInicial()) <= 0) {
            throw new Exception("Datas inválidas");
        }
        emprestimo.setStatus(StatusEmprestimo.RESERVADO);
        emprestimoRepository.save(emprestimo);
        return emprestimo;
    }

    public void iniciaEmprestimoPorId(Long id) throws Exception{
        Emprestimo emprestimoIniciado = emprestimoRepository.findByIdEmprestimo(id);
        if (emprestimoIniciado.getStatus() != StatusEmprestimo.RESERVADO) {
            throw new Exception("Emprestimo não está reservado");
        }
        emprestimoIniciado.setStatus(StatusEmprestimo.EMANDAMENTO);
        emprestimoRepository.save(emprestimoIniciado);
    }

    public List<Emprestimo> listaEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo listaEmprestimoPorId(Long id) {
        return emprestimoRepository.findByIdEmprestimo(id);
    }

    public List<Emprestimo> listaEmprestimosPorLivro(String nome) {
        return emprestimoRepository.findAllByExemplar_Livro_titulo(nome);
    }

    public void deletaEmprestimoPorId(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findByIdEmprestimo(id);
        emprestimoRepository.delete(emprestimo);
    }

    public Emprestimo editaEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo cancelaEmprestimoPorId(Long id) throws Exception{
        Emprestimo emprestimoCancelado = emprestimoRepository.findByIdEmprestimo(id);
        if (emprestimoCancelado.getStatus() == StatusEmprestimo.REALIZADO) {
            throw new Exception("Não é possível cancelar um empréstimo finalizado");
        }
        emprestimoCancelado.setStatus(StatusEmprestimo.CANCELADO);
        emprestimoRepository.save(emprestimoCancelado);
        return emprestimoCancelado;
    }

    public void renovaEmprestimoPorId(Long id, LocalDate novaDataFinal) throws Exception {
        Emprestimo emprestimoRenovado = emprestimoRepository.findByIdEmprestimo(id);
        if (emprestimoRenovado.getDataFinal().compareTo(novaDataFinal) >= 0) {
            throw new Exception("Data inválida");
        }
        emprestimoRenovado.setDataFinal(novaDataFinal);
        emprestimoRepository.save(emprestimoRenovado);
    }

    public List<Emprestimo> listaEmprestimosReservados() {
        return emprestimoRepository.findAllByStatus_Reservado();
    }

    public List<Emprestimo> listaEmprestimosRealizados() {
        return emprestimoRepository.findAllByStatus_Realizado();
    }

    public List<Emprestimo> listaEmprestimosCancelados() {
        return emprestimoRepository.findAllByStatus_Cancelado();
    }

    public List<Emprestimo> listaEmprestimosAndamento() {
        return emprestimoRepository.findAllByStatus_Andamento();
    }

    public Emprestimo finalizaEmprestimoPorId(Long id) {
        Emprestimo emprestimoFinalizado = emprestimoRepository.findByIdEmprestimo(id);
        emprestimoFinalizado.setStatus(StatusEmprestimo.REALIZADO);
        emprestimoRepository.save(emprestimoFinalizado);
        return emprestimoFinalizado;
    }
}
