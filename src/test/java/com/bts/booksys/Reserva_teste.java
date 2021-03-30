package com.bts.booksys;

import com.bts.booksys.Reserva.Reserva;
import com.bts.booksys.Reserva.ReservaService;
import com.bts.booksys.Reserva.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Reserva_teste {

    @Autowired
    ReservaService reservaService;

    @Test
    void insereReserva() {
        Reserva reserva = new Reserva();
        reserva.setDataInicial(LocalDate.now());
        reserva.setDataFinal(LocalDate.now());
        reserva.setStatus(Status.RESERVADO);
        reserva.setValorTotal(400.00);

        Reserva reservaSalvo = reservaService.salvaReserva(reserva);
        Assertions.assertEquals(reserva, reservaSalvo);
    }

    @Test
    void listaReservas() {
        Reserva reserva1 = new Reserva();
        reserva1.setDataInicial(LocalDate.now());
        reserva1.setDataFinal(LocalDate.now());
        reserva1.setStatus(Status.RESERVADO);
        reserva1.setValorTotal(400.00);

        Reserva reserva2 = new Reserva();
        reserva2.setDataInicial(LocalDate.now());
        reserva2.setDataFinal(LocalDate.now());
        reserva2.setStatus(Status.CANCELADO);
        reserva2.setValorTotal(300.00);

        reservaService.salvaReserva(reserva1);
        reservaService.salvaReserva(reserva2);

        List<Reserva> reservasModelo = new ArrayList<Reserva>();
        reservasModelo.add(reserva1);
        reservasModelo.add(reserva2);

        List<Reserva> reservasListados = reservaService.listaReservas();
         Assertions.assertEquals(reservasModelo.size(), reservasListados.size());
    }

    @Test
    void listaReservaPorId() {
        Reserva reserva1 = new Reserva();
        reserva1.setIdReserva(1L);
        reserva1.setDataInicial(LocalDate.now());
        reserva1.setDataFinal(LocalDate.now());
        reserva1.setStatus(Status.RESERVADO);
        reserva1.setValorTotal(400.00);

        Reserva reserva2 = new Reserva();
        reserva2.setIdReserva(1L);
        reserva2.setDataInicial(LocalDate.now());
        reserva2.setDataFinal(LocalDate.now());
        reserva2.setStatus(Status.CANCELADO);
        reserva2.setValorTotal(300.00);

        reservaService.salvaReserva(reserva1);
        reservaService.salvaReserva(reserva2);

        Reserva reservaComId2 = reservaService.listaReservaPorId(2L);
        Assertions.assertNotNull(reservaComId2);
    }

    @Test
    void cancelaReserva() {
        Reserva reserva1 = new Reserva();
        reserva1.setIdReserva(1L);
        reserva1.setDataInicial(LocalDate.now());
        reserva1.setDataFinal(LocalDate.of(2021, 9,9));
        reserva1.setStatus(Status.RESERVADO);
        reserva1.setValorTotal(400.00);

        reservaService.cancelaReserva(1L);

        Assertions.assertEquals(reserva1.getStatus(), Status.CANCELADO);
    }
}
