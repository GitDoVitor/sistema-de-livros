package com.bts.booksys.services;

import com.bts.booksys.models.Autor;
import com.bts.booksys.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    final
    AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor salvaAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> listaAutores() {
        return autorRepository.findAll();
    }

    public Autor listaAutorPorId(Long id) {
        return autorRepository.findByIdAutor(id);
    }

    public void deletaAutorPorId(Long id) {
        autorRepository.deleteById(id);
    }

    public Autor editaAutor(Long id, String nome) {
        Autor autor1 = autorRepository.findByIdAutor(id);
        autor1.setNome(nome);
        return autorRepository.save(autor1);
    }

}
