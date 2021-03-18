package com.bts.booksys.Autor;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Autor {
    @Id
    private Long id;
    private String nome;
}
