package com.bts.booksys.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Atendente {

    @Id
    @GeneratedValue
    private Long idAtendente;
    @NotBlank
    private String nome;
    @NotBlank
    private String senha;
}
