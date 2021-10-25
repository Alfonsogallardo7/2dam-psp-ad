package com.salesianostriana.dam.E07ManyToMany.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Artist {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany (mappedBy = "Artist")
    private List<Song> songs = new ArrayList<>();

}
