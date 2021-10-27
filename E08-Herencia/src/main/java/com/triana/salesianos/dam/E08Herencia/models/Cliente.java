package com.triana.salesianos.dam.E08Herencia.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombreEmpresa;

    private String email;

    private int telefono;

    public Cliente(String nombreEmpresa, String email, int telefono) {
        this.nombreEmpresa = nombreEmpresa;
        this.email = email;
        this.telefono = telefono;
    }
}
