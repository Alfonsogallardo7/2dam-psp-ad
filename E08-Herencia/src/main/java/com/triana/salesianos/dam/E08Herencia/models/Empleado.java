package com.triana.salesianos.dam.E08Herencia.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private String apellidos;

    private String departamento;

    private String email;

    @OneToMany (mappedBy = "empleado")
    @Builder.Default
    private List<ClienteCorporativo> listaClienteCorporativos = new ArrayList<>();

    //////////////////////////////////////////////
    /*              MÉTODOS HELPER              */
    //////////////////////////////////////////////

    public void addClienteCorporativo (ClienteCorporativo cc ){
        this.listaClienteCorporativos.add(cc);
        cc.setEmpleado(this);
    }

    public void removeClienteCorporativo (ClienteCorporativo cc){
        this.listaClienteCorporativos.remove(cc);
        cc.setEmpleado(null);
    }
}
