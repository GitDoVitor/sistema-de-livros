package com.bts.booksys.services;

import com.bts.booksys.models.Editora;
import com.bts.booksys.repositories.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {
    final
    EditoraRepository editoraRepository;

    @Autowired
    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public List<Editora> listaEditoras(){
        return editoraRepository.findAll();
    }

    public Editora listaEditoraPorId(Long id) {
        return editoraRepository.findByIdEditora(id);
    }

    public Editora salvaEditora(Editora editora) {
        return editoraRepository.save(editora);
    }

    public Editora editaEditora(Long id, Editora editora) {
        Editora editora1 = editoraRepository.findByIdEditora(id);
        editora1.setNome(editora.getNome());
        return editoraRepository.save(editora1);
    }

    public void deletaEditora(Long id) {
        editoraRepository.deleteById(id);
    }
}
