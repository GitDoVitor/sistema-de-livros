package com.bts.booksys.models;

import com.bts.booksys.enums.StatusExemplar;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExemplar;
    @Column(unique=true)
    @NotBlank
    private Long ISBN;
    @NotBlank
    private StatusExemplar status;
    @ManyToOne
    private Livro livro;
}
