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
        Autor autor = autorRepository.findByIdAutor(id);
        autorRepository.delete(autor);
    }

    public Autor editaAutor(Long id, Autor autor) {
        Autor autor1 = autorRepository.findByIdAutor(id);
        autor1.setNome(autor.getNome());
        return autorRepository.save(autor1);
    }

}
