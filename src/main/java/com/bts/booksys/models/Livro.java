package com.bts.booksys.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;
    private String titulo;
    @ManyToOne
    private Editora editora;
    @ManyToMany
    private List<Autor> autor;
    @ManyToOne
    private Genero genero;
    private Double preco;
    private Long edicao;
    private Long numPagina;
    private LocalDate dataPublicacao;
}
