package com.salesianostriana.dam.E07ManyToMany.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Playlist {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name= "name")
    private String description;

    @Builder.Default
    @ManyToMany
    private List<Song> songs = new ArrayList<>();

    /////////////////////////////////////////////////
    /*              MÉTODOS HELPER                 */
    /////////////////////////////////////////////////

    public void addSong (Song s) {
        if (this.getSongs() == null) {
            this.setSongs(new ArrayList<>());
            this.getSongs().add(s);
        }

        if (s.getPlaylists() == null) {
            s.setPlaylists(new ArrayList<>());
            s.getPlaylists().add(this);
        }
    }

    public void removeSong (Song s){
        s.getPlaylists().remove(this);
        this.getSongs().remove(s);
    }

}
