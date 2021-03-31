package com.bts.booksys.services;

import com.bts.booksys.enums.StatusReserva;
import com.bts.booksys.models.Reserva;
import com.bts.booksys.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva salvaReserva(Reserva reserva) {
        reservaRepository.save(reserva);
        return reserva;
    }

    public List<Reserva> listaReservas() {
        return reservaRepository.findAll();
    }

    public Reserva listaReservaPorId(Long id) {
        return reservaRepository.findByIdReserva(id);
    }

    public void deletaReservaPorId(Long id) {
        Reserva reserva = reservaRepository.findByIdReserva(id);
        reservaRepository.delete(reserva);
    }

    public Reserva editaReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva cancelaReserva(Long id) {
        Reserva reservaCancelada = reservaRepository.findByIdReserva(id);
        reservaCancelada.setStatus(StatusReserva.CANCELADO);
        return reservaCancelada;
    }
}
