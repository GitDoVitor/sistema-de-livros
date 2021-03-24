package com.bts.booksys.Atendente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendenteService {

    private final AtendenteRepository atendenteRepository;

    @Autowired
    public AtendenteService(AtendenteRepository atendenteRepository) {
        this.atendenteRepository = atendenteRepository;
    }

    public Atendente salvaAtendente(Atendente atendente) {
        atendenteRepository.save(atendente);
        return atendente;
    }

    public List<?> listaAtendentes() {
        return atendenteRepository.findAll();
    }

    public Atendente listaAtendentePorId(Long id) {
        return atendenteRepository.findByIdAtendente(id);
    }

    public void deletaAtendentePorId(Long id) {
        Atendente atendente = atendenteRepository.findByIdAtendente(id);
        atendenteRepository.delete(atendente);
    }

    public Atendente editaAtendente(Atendente atendente) {
        return atendenteRepository.save(atendente);
    }
}
