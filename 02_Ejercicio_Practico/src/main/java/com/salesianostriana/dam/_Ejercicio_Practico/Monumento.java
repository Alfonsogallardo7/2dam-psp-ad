package com.salesianostriana.dam._Ejercicio_Practico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;

    private String codigoPais;

    private String nombrePais;

    private String nombreCiudad;

    private String latitud;

    private String altitud;

    private String nombreMonumento;

    private String descripcion;

    private String urlFoto;

    public Monumento(String codigoPais, String nombrePais, String nombreCiudad, String latitud, String altitud, String nombreMonumento, String descripcion, String urlFoto) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.nombreCiudad = nombreCiudad;
        this.latitud = latitud;
        this.altitud = altitud;
        this.nombreMonumento = nombreMonumento;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
    }
}
