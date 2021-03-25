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
