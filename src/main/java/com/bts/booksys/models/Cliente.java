package com.bts.booksys.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long idCliente;
    private String nome;
    private String email;
    private String telefone;
}
