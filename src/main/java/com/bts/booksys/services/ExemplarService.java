package com.bts.booksys.services;

import com.bts.booksys.models.Atendente;
import com.bts.booksys.models.Exemplar;
import com.bts.booksys.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemplarService {

    final ExemplarRepository exemplarRepository;

    @Autowired
    public ExemplarService(ExemplarRepository exemplarRepository) {
        this.exemplarRepository = exemplarRepository;
    }

    public Exemplar salvaExemplar(Exemplar exemplar) {
        exemplarRepository.save(exemplar);
        return exemplar;
    }

    public List<Exemplar> listaExemplares() {
        return exemplarRepository.findAll();
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
