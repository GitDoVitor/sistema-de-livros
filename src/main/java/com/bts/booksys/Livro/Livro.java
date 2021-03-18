package com.bts.booksys.Livro;

import com.bts.booksys.Editora.Editora;
import com.bts.booksys.Genero.Genero;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    private Editora editora;
    private Long ISBN;
    @ManyToOne
    private Genero genero;
    private Double preco;
    private Long edicao;
    private Long numPagina;
    private LocalDate dataPublicacao;
    private Status status;
}
