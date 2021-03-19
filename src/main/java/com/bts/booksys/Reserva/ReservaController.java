package com.bts.booksys.Reserva;

import com.bts.booksys.Cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<?> insereReserva(@RequestBody Reserva reserva) {
        reservaService.salvaReserva(reserva);
        return new ResponseEntity<>(reserva, null, HttpStatus.CREATED);
    }

    @GetMapping
    public List<?> listaReservas() {
        return reservaService.listaReservas();
    }

    @GetMapping("/{id}")
    public Reserva listaReservaPorId(@PathVariable Long id) {
        return reservaService.listaReservaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaReservaPorId(Long id) {
        reservaService.deletaReservaPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> editaReserva(@RequestBody Reserva reserva) {
        reservaService.editaReserva(reserva);
        return new ResponseEntity<>(reserva, null, HttpStatus.ACCEPTED);
    }
}
