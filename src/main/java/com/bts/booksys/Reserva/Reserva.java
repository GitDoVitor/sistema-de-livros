package com.bts.booksys.Reserva;

import com.bts.booksys.Cliente.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Reserva {

    @Id
    @GeneratedValue
    private Long idReserva;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Double valorTotal;
    private Status status;
    @ManyToOne
    private Cliente cliente;
}
