package com.salesianostriana.dam.E07ManyToMany.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Song {

    @Id
    @GeneratedValue
    private Long id;

    private String tittle;

    @ManyToOne
    private Artist artists;

    private String album;

    private String year;

    public Song(String tittle, String album, String year) {
        this.tittle = tittle;
        this.album = album;
        this.year = year;
    }

    public Song(String tittle, Artist artists, String album, String year) {
        this.tittle = tittle;
        this.artists = artists;
        this.album = album;
        this.year = year;
    }
}

