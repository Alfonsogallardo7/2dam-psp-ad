package com.triana.salesianos.dam.E08Herencia.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Pedidos {

    @Id
    @GeneratedValue
    private Long id;

    private String codPedido;

    private Double total;
}
