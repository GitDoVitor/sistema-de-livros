package com.bts.booksys.services;

import com.bts.booksys.enums.StatusExemplar;
import com.bts.booksys.models.Emprestimo;
import com.bts.booksys.models.Exemplar;
import com.bts.booksys.repositories.EmprestimoRepository;
import com.bts.booksys.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<Exemplar> listaExemplaresDisponiveisPorData(LocalDate dataInicial, LocalDate dataFinal) {

        List<Exemplar> listaNaoFiltrada = exemplarRepository.findAll();
        List<Emprestimo> listaDeEmprestimos = emprestimoRepository.findAll();
        List<Emprestimo> listaDeConflitos = new ArrayList<>();
        List<Exemplar> listaDeExemplaresComConflito = new ArrayList<>();

        for(Emprestimo temp : listaDeEmprestimos){
            if(temp.getDataInicial().compareTo(dataInicial) <= 0 && temp.getDataFinal().compareTo(dataFinal) >= 0) {
                listaDeConflitos.add(temp);
            } else if(temp.getDataFinal().compareTo(dataInicial) >= 0 && temp.getDataFinal().compareTo(dataFinal) <= 0) {
                listaDeConflitos.add(temp);
            } else if(temp.getDataInicial().compareTo(dataInicial) >= 0 && temp.getDataInicial().compareTo(dataFinal) <= 0) {
                listaDeConflitos.add(temp);
            }
        }

        for(Emprestimo temp2 : listaDeConflitos) {
            listaDeExemplaresComConflito.add(temp2.getExemplar());
        }

        return listaNaoFiltrada.stream()
                .filter(e -> !listaDeExemplaresComConflito.contains(e))
                .collect (Collectors.toList());
    }

    public Long listaLivroDisponivelPorData(String nomeDoLivro, LocalDate dataInicial, LocalDate dataFinal) {

        List<Exemplar> listaNaoFiltrada = exemplarRepository.findAllByLivro_titulo(nomeDoLivro);
        List<Emprestimo> listaDeEmprestimos = emprestimoRepository.findAllByExemplar_Livro_titulo(nomeDoLivro);
        List<Emprestimo> listaDeConflitos = new ArrayList<>();
        List<Exemplar> listaDeExemplaresComConflito = new ArrayList<>();

        for(Emprestimo temp : listaDeEmprestimos){
            if(temp.getDataInicial().compareTo(dataInicial) <= 0 && temp.getDataFinal().compareTo(dataFinal) >= 0) {
                listaDeConflitos.add(temp);
            } else if(temp.getDataFinal().compareTo(dataInicial) >= 0 && temp.getDataFinal().compareTo(dataFinal) <= 0) {
                listaDeConflitos.add(temp);
            } else if(temp.getDataInicial().compareTo(dataInicial) >= 0 && temp.getDataInicial().compareTo(dataFinal) <= 0) {
                listaDeConflitos.add(temp);
            }
        }

        for(Emprestimo temp2 : listaDeConflitos) {
            listaDeExemplaresComConflito.add(temp2.getExemplar());
        }

        List<Exemplar> listaFiltrada = listaNaoFiltrada.stream()
                .filter(e -> !listaDeExemplaresComConflito.contains(e))
                .collect (Collectors.toList());

        return (long) listaFiltrada.size();
    }

    public Exemplar listaExemplarPorId(Long id) {
        return exemplarRepository.findByIdExemplar(id);
    }

    public List<Exemplar> listaExemplaresPorTituloDeLivro(String titulo) {
        return exemplarRepository.findAllByLivro_titulo(titulo);
    }

    public void deletaExemplarPorId(Long id) {
        Exemplar exemplar = exemplarRepository.findByIdExemplar(id);
        exemplarRepository.delete(exemplar);
    }

    public Exemplar editaExemplar(Exemplar exemplar) {
        return exemplarRepository.save(exemplar);
    }
}
