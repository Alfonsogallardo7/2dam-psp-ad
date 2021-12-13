package com.salesianostriana.dam.PracticaGuiada.models;

import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class EstacionServicio {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String marca;

    private String ubicacion;

    private boolean autolavado;

    private double precioGasoilNormal;

    private double precioGasoilEspecial;

    private double precioGasolina95;

    private double precioGasolina98;

    @Lob
    private String servicios;

    private LocalDate fechaApertura;



}
