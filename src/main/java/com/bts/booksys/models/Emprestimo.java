package com.bts.booksys.models;

import com.bts.booksys.enums.StatusEmprestimo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Emprestimo {

    @Id
    @GeneratedValue
    private Long idEmprestimo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalDate dataEntregue;
    private Double valorTotal;
    private StatusEmprestimo status;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
    private List<Exemplar> exemplares;
}
