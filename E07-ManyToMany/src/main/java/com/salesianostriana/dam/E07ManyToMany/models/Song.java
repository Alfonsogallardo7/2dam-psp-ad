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

    @Column (name = "tittle")
    private String tittle;

    @ManyToOne
    @JoinColumn(name = "artist_id", foreignKey = @ForeignKey(name = "FK_SONG_ARTIST"))
    private Artist artists;

    @Column (name = "album")
    private String album;

    @Column (name = "year")
    private String year;

    @Builder.Default
    @ManyToMany
    private List<Playlist> playlists = new ArrayList<>();

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

    /////////////////////////////////////////////////
    /*              MÉTODOS HELPER                 */
    /////////////////////////////////////////////////

    public void addArtist (Artist a){
        this.artists = a;
        a.getSongs().add(this);
    }

    public void removeArtist (Artist a){
        a.getSongs().remove(this);
        this.artists = null;
    }
}

