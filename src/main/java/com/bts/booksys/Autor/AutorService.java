package com.bts.booksys.Autor;

import com.bts.booksys.Atendente.Atendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    final
    AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void salvaAutor(Autor autor) {
        autorRepository.save(autor);
    }

    public List<?> listaAutores() {
        return autorRepository.findAll();
    }

    public Autor listaAutorPorId(Long id) {
        return autorRepository.findByIdAutor(id);
    }

    public void deletaAutorPorId(Long id) {
        Autor autor = autorRepository.findByIdAutor(id);
        autorRepository.delete(autor);
    }

    public Autor editaAutor(Autor autor) {
        return autorRepository.save(autor);
    }

}
