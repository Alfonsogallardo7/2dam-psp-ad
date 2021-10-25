package com.salesianostriana.dam.E07ManyToMany.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Artist {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany (mappedBy = "Artist")
    private List<Song> songs = new ArrayList<>();

    //////////////////////////////////////////
    /*             MÉTODOS HELPER           */
    //////////////////////////////////////////

    public void addSong(Song s) {
        this.songs.add(s);
        s.setArtists(this);
    }

    public void removeSong(Song s) {
        this.songs.remove(s);
        s.setArtists(null);
    }
}
