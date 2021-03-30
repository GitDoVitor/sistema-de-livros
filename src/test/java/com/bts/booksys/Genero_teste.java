package com.bts.booksys;

import com.bts.booksys.Genero.Genero;
import com.bts.booksys.Genero.GeneroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Genero_teste {
    @Autowired
    GeneroService generoService;

    @Test
    void editaGenero() {
        Genero genero1 = new Genero();
        genero1.setNome("Comédia3");
        Genero genero = generoService.salvaGenero(genero1);

        genero.setNome("Terror");

        generoService.editaGenero(genero);

        Genero teste = generoService.listaGeneroPorId(1L);
        Assertions.assertEquals("Terror", teste.getNome());
    }

    @Test
    void criaGenero() {
        Genero genero = new Genero();
        genero.setNome("Comédia2");
        Genero generoCriado = generoService.salvaGenero(genero);

        Assertions.assertNotNull(generoCriado);
        Assertions.assertEquals(genero, generoCriado);
    }

    @Test
    void apagaGenero() {
        Genero genero1 = new Genero();
        genero1.setIdGenero(1L);
        genero1.setNome("Comédia4");
        Genero genero = generoService.salvaGenero(genero1);

        generoService.deletaGeneroPorId(genero.getIdGenero());
        Genero teste = generoService.listaGeneroPorId(1L);
        Assertions.assertNull(teste);
    }

    @Test
    void listaGeneros() {
        Genero genero1 = new Genero();
        Genero genero2 = new Genero();

        genero1.setNome("Comédia");
        genero2.setNome("Terror");

        generoService.salvaGenero(genero1);
        generoService.salvaGenero(genero2);

        List<?> generoList = generoService.listaGeneros();

        Assertions.assertEquals(2, generoList.size());
    }
}
