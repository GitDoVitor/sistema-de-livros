package com.bts.booksys.Reserva;

import com.bts.booksys.Cliente.Cliente;
import com.bts.booksys.Livro.Livro;
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
    private Double valorTotal;
    private Status status;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
    private List<Livro> livros;
}
