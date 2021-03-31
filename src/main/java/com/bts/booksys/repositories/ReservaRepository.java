package com.bts.booksys.repositories;

import com.bts.booksys.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Reserva findByIdReserva(Long id);
}
