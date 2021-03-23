package com.bts.booksys.Editora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {
    final
    EditoraRepository editoraRepository;

    @Autowired
    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    List<Editora> listaEditoras(){
        return editoraRepository.findAll();
    }

    Optional<Editora> listaEditoraPorId(Long id) {
        return editoraRepository.findByIdEditora(id);
    }

    Editora salvaEditora(Editora editora) {
        return editoraRepository.save(editora);
    }


}
