package com.bts.booksys;

import com.bts.booksys.Editora.Editora;
import com.bts.booksys.Editora.EditoraService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Editora_teste {
    @Autowired
    EditoraService editoraService;

    @Test
    void insereEditora() {
        Editora editora = new Editora();
        editora.setNome("Arqueiro");

        Editora editoraCriada = editoraService.salvaEditora(editora);

        Assertions.assertNotNull(editoraCriada);
        Assertions.assertEquals(editora, editoraCriada);
    }

    @Test
    void listaTodasEditoras() {
        Editora editora1 = new Editora();
        Editora editora2 = new Editora();

        editora1.setNome("Arqueiro");
        editora2.setNome("Companhia das Letras");

        editoraService.salvaEditora(editora1);
        editoraService.salvaEditora(editora2);

        List<Editora> editoraList = editoraService.listaEditoras();

        Assertions.assertEquals(2, editoraList.size());
    }

    @Test
    void editaEditora() {

        Editora editora1 = new Editora();
        Editora editora2 = new Editora();

        editora1.setNome("Arqueiro");
        editora2.setNome("Compania das Letras");

        editoraService.salvaEditora(editora1);
        Editora editora = editoraService.salvaEditora(editora2);

        Assertions.assertEquals("Compania das Letras", editora2.getNome());
        editora.setNome("Companhia das Letras");

        editoraService.editaEditora(2L, editora);

        Editora teste = editoraService.listaEditoraPorId(2L);
        Assertions.assertEquals("Companhia das Letras", teste.getNome() );
    }

    @Test
    void apagaEditoraPorID() {
        Editora editora1 = new Editora();
        Editora editora2 = new Editora();

        editora1.setIdEditora(1L);
        editora2.setIdEditora(2L);
        editora1.setNome("Arqueiro");
        editora2.setNome("Compania das Letras");

        editoraService.salvaEditora(editora1);
        editoraService.salvaEditora(editora2);

        editoraService.deletaEditora(1L);

        Editora teste = editoraService.listaEditoraPorId(1L);
        Assertions.assertNull(teste);
    }
}
