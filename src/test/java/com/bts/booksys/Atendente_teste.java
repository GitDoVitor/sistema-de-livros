package com.bts.booksys;

import com.bts.booksys.Atendente.Atendente;
import com.bts.booksys.Atendente.AtendenteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Atendente_teste {

    @Autowired
    private AtendenteService atendenteService;

    @Test
    void insereAtendente() {
        Atendente atendente = new Atendente();
        atendente.setNome("Jose");
        atendente.setSenha("senhaboa");

        Atendente atendenteSalvo = atendenteService.salvaAtendente(atendente);
        Assertions.assertEquals(atendente, atendenteSalvo);
    }

    @Test
    void listaAtendentes() {
        Atendente atendente1 = new Atendente();
        atendente1.setNome("Jose");
        atendente1.setSenha("senhaboa1");

        Atendente atendente2 = new Atendente();
        atendente2.setNome("Maria");
        atendente2.setSenha("senhaboa2");

        atendenteService.salvaAtendente(atendente1);
        atendenteService.salvaAtendente(atendente2);

        List<Atendente> atendentesLista = (List<Atendente>) atendenteService.listaAtendentes();
        Assertions.assertEquals(2, atendentesLista.size());
    }

    @Test
    void listaAtendentePorId() {
        Atendente atendente1 = new Atendente();
        atendente1.setIdAtendente(1L);
        atendente1.setNome("Jose");
        atendente1.setSenha("senhaboa1");

        Atendente atendente2 = new Atendente();
        atendente2.setIdAtendente(2L);
        atendente2.setNome("Maria");
        atendente2.setSenha("senhaboa2");

        atendenteService.salvaAtendente(atendente1);
        atendenteService.salvaAtendente(atendente2);

        Atendente atendenteComId2 = atendenteService.listaAtendentePorId(2L);
        Assertions.assertNotNull(atendenteComId2);
    }

    @Test
    void deletaAtendentePorId() {
        Atendente atendente1 = new Atendente();
        atendente1.setIdAtendente(1L);
        atendente1.setNome("Jose");
        atendente1.setSenha("senhaboa1");

        atendenteService.salvaAtendente(atendente1);
        atendenteService.deletaAtendentePorId(1L);
        Atendente atendenteDeletado = atendenteService.listaAtendentePorId(1L);

        Assertions.assertNull(atendenteDeletado);
    }

    @Test
    void editaAtendente() {
        Atendente atendente1 = new Atendente();
        atendente1.setIdAtendente(1L);
        atendente1.setNome("Jose");
        atendente1.setSenha("senhaboa1");

        atendenteService.salvaAtendente(atendente1);

        Atendente atendente2 = new Atendente();
        atendente2.setIdAtendente(1L);
        atendente2.setNome("Maria");
        atendente2.setSenha("senhaboa1");

        Atendente atendenteEditado = atendenteService.editaAtendente(atendente2);
        Atendente atendenteSalvo = atendenteService.listaAtendentePorId(1L);

        Assertions.assertEquals(atendenteEditado.getNome(), atendenteSalvo.getNome());
    }
}
