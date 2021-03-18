package com.bts.booksys.Editora;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Editora {
    @Id
    private Long id;

    private String nome;
}
