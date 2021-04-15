package com.bts.booksys;

import com.bts.booksys.models.Autor;
import com.bts.booksys.services.AutorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Autor_teste {
    @Autowired
    private AutorService autorService;

    @Test
    void insereAutor() {
        Autor autor = new Autor();
        autor.setNome("Machado de Assis");

        Autor autorSalvo = autorService.salvaAutor(autor);

        Assertions.assertNotNull(autorSalvo);
        Assertions.assertEquals(autor, autorSalvo);
    }

    @Test
    void listaTodosAutores() {
        Autor autor1 = new Autor();
        Autor autor2 = new Autor();

        autor1.setNome("Machado de Assis");
        autor2.setNome("J. K. Rowling");

        autorService.salvaAutor(autor1);
        autorService.salvaAutor(autor2);

        List<Autor> autorList = autorService.listaAutores();

        Assertions.assertEquals(2, autorList.size());
    }

    @Test
    void editaAutor() {
        Autor autor1 = new Autor();
        Autor autor2 = new Autor();

        autor1.setNome("Machado de Assis");
        autor2.setNome("J. K. Rowling");

        autorService.salvaAutor(autor1);
        autorService.salvaAutor(autor2);
        autorService.editaAutor(2L, "Taran Matharu");
        autorService.salvaAutor(autor2);

        Autor teste = autorService.listaAutorPorId(2L);
        Assertions.assertEquals("Taran Matharu", teste.getNome() );
    }

    @Test
    void apagaAutorPorID() {
        Autor autor1 = new Autor();
        Autor autor2 = new Autor();

        autor1.setIdAutor(1L);
        autor2.setIdAutor(2L);
        autor1.setNome("Machado de Assis");
        autor2.setNome("J. K. Rowling");

        autorService.salvaAutor(autor1);
        autorService.salvaAutor(autor2);

        autorService.deletaAutorPorId(autor1.getIdAutor());

        Autor teste = autorService.listaAutorPorId(1L);
        Assertions.assertNull(teste);
    }


}
