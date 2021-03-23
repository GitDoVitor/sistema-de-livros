package com.bts.booksys.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    final
    LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro criaUm(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listaTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> listaTodosPorTitulo(String titulo) {
        return livroRepository.findAllByTitulo(titulo);
    }

    public Optional<Livro> listaPorID(Long id){
        return livroRepository.findById(id);
    }
//    TODO
//    public List<Livro> listaPorGenero()

    public void apagaUm(Long id) {
        livroRepository.deleteById(id);
    }
}
