package com.bts.booksys.Reserva;

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

    public void salvaReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public List<?> listaReservas() {
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
}
