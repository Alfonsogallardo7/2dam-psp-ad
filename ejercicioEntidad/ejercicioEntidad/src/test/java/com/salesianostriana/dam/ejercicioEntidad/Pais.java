package com.salesianostriana.dam.ejercicioEntidad;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Table(name="country")
public class Pais implements Serializable    {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String nombre;
}
