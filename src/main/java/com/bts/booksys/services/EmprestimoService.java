package com.bts.booksys.services;

import com.bts.booksys.enums.StatusEmprestimo;
import com.bts.booksys.models.Emprestimo;
import com.bts.booksys.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    @Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public Emprestimo salvaEmprestimo(Emprestimo emprestimo) {
        emprestimoRepository.save(emprestimo);
        return emprestimo;
    }

    public List<Emprestimo> listaEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo listaEmprestimoPorId(Long id) {
        return emprestimoRepository.findByIdEmprestimo(id);
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
}
