package com.salesianostriana.dam.E07ManyToMany.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Playlist {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Lob
    private String description;
}
