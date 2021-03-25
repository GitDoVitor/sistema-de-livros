package com.bts.booksys.Genero;

import com.bts.booksys.Atendente.Atendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {
    final
    GeneroRepository generoRepository;

    @Autowired
    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public Genero salvaGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    public List<?> listaGeneros() {
        return generoRepository.findAll();
    }

    public Genero listaGeneroPorId(Long id) {
        return generoRepository.findByIdGenero(id);
    }

    public void deletaGeneroPorId(Long id) {
        generoRepository.deleteById(id);
    }

    public Genero editaGenero(Genero genero) {
        return generoRepository.save(genero);
    }
}
