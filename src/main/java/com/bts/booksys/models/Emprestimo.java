package com.bts.booksys.models;

import com.bts.booksys.enums.StatusEmprestimo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Emprestimo {

    @Id
    @GeneratedValue
    private Long idEmprestimo;
    @NotBlank
    private LocalDate dataInicial;
    @NotBlank
    private LocalDate dataFinal;
    @NotBlank
    private LocalDate dataEntregue;
    @NotBlank
    private Double valorTotal;
    @NotBlank
    private StatusEmprestimo status;
    @ManyToOne
    private Cliente cliente;
    @OneToOne
    private Exemplar exemplar;
}
