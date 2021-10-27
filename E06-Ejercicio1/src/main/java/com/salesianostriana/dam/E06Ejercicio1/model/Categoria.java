package com.salesianostriana.dam.E06Ejercicio1.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Categoria implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @Builder.Default
    @OneToMany(mappedBy = "categoria")
    private List <Producto> productos = new ArrayList<>();
    

}
