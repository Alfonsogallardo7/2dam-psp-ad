package com.triana.salesianos.dam.E08Herencia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity @SuperBuilder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ClienteCorporativo extends Cliente implements Serializable {

    private String codigoEmpresa;

    @ManyToOne
    private Empleado empleado;

    public ClienteCorporativo(String nombreEmpresa, String email, int telefono, String codigoEmpresa) {
        super(nombreEmpresa, email, telefono);
        this.codigoEmpresa = codigoEmpresa;
    }
}
