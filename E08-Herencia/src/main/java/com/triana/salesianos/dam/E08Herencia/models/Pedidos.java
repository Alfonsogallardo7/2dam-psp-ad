package com.triana.salesianos.dam.E08Herencia.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Pedidos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codPedido;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "KF_PEDIDO_CLIENTE"))
    private Cliente cliente;
}
