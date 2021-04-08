package com.bts.booksys.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long idCliente;
    @NotBlank
    private String nome;
    @Email(message = "email inválido")
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 9)
    private String telefone;
}
