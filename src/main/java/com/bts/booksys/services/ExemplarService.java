package com.bts.booksys.services;

import com.bts.booksys.enums.StatusExemplar;
import com.bts.booksys.models.Emprestimo;
import com.bts.booksys.models.Exemplar;
import com.bts.booksys.repositories.EmprestimoRepository;
import com.bts.booksys.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExemplarService {

    final ExemplarRepository exemplarRepository;

    @Autowired
    public ExemplarService(ExemplarRepository exemplarRepository) {
        this.exemplarRepository = exemplarRepository;
    }

    @Autowired
    EmprestimoRepository emprestimoRepository;

    public Exemplar salvaExemplar(Exemplar exemplar) {
        exemplarRepository.save(exemplar);
        return exemplar;
    }

    public List<Exemplar> listaExemplaresDisponiveis(LocalDate dataInicial, LocalDate dataFinal) {

        List<Exemplar> listaNaoFiltrada = exemplarRepository.findAllByStatus(StatusExemplar.DISPONIVEL);
        List<Emprestimo> listaDeEmprestimos = emprestimoRepository.findAll();
        List<Emprestimo> listaDeConflitos = null;
        List<List<Exemplar>> listaDeExemplaresComConflito = null;

        for(Emprestimo temp : listaDeEmprestimos){

            if(temp.getDataInicial().compareTo(dataInicial) > 0 && temp.getDataInicial().compareTo(dataFinal) < 0) {
                listaDeConflitos.add(temp);
            } else if(temp.getDataFinal().compareTo(dataInicial) > 0 && temp.getDataFinal().compareTo(dataFinal) < 0) {
                listaDeConflitos.add(temp);
            } else if(temp.getDataInicial().compareTo(dataInicial) < 0 && temp.getDataFinal().compareTo(dataFinal) > 0) {
                listaDeConflitos.add(temp);
            }
        }

        for(Emprestimo temp2 : listaDeConflitos) {
            listaDeExemplaresComConflito.add(temp2.getExemplares());
        }

        return listaNaoFiltrada.stream()
                                .filter(e -> !listaDeExemplaresComConflito.contains(e))
                                .collect (Collectors.toList());
    }


    public Exemplar listaExemplarPorId(Long id) {
        return exemplarRepository.findByIdExemplar(id);
    }

    public void deletaExemplarPorId(Long id) {
        Exemplar exemplar = exemplarRepository.findByIdExemplar(id);
        exemplarRepository.delete(exemplar);
    }

    public Exemplar editaExemplar(Exemplar exemplar) {
        return exemplarRepository.save(exemplar);
    }
}
