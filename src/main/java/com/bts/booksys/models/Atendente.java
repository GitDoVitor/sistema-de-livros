package com.bts.booksys.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Atendente {

    @Id
    @GeneratedValue
    private Long idAtendente;
    private String nome;
    private String senha;
}
