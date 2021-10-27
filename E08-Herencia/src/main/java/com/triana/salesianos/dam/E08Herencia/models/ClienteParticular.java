package com.triana.salesianos.dam.E08Herencia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity @SuperBuilder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ClienteParticular extends Cliente implements Serializable {

    private String nombreEmpleado;

    private String email;

    public ClienteParticular(String nombreEmpresa, String email, int telefono, String nombreEmpleado) {
        super(nombreEmpresa, email, telefono);
        this.nombreEmpleado = nombreEmpleado;
    }
}
