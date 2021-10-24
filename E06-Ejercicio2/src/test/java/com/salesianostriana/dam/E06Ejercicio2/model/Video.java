package com.salesianostriana.dam.E06Ejercicio2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Video implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String orden;

    private String titulo;

    @Lob
    private String descripcion;

    private String url;

    @ManyToOne
    @JoinColumn(name = "cursoOnline_id", foreignKey = @ForeignKey(name = "FK_VIDEO_CURSOONLINE"))
    private CursoOnline cursoOnline;

}
