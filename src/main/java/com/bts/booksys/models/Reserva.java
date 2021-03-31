package com.bts.booksys.models;

import com.bts.booksys.enums.StatusReserva;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Reserva {

    @Id
    @GeneratedValue
    private Long idReserva;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalDate dataEntregue;
    private Double valorTotal;
    private StatusReserva status;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
    private List<Exemplar> exemplares;
}
