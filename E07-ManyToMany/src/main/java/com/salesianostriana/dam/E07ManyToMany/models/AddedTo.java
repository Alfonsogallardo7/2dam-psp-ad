package com.salesianostriana.dam.E07ManyToMany.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class AddedTo implements Serializable {

    @Builder.Default
    @EmbeddedId
    private AddedToPk id = new AddedToPk();

    @ManyToOne
    @MapsId("playlist_id")
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @MapsId("song_id")
    @JoinColumn(name = "song_id")
    private Song song;

    private String dateTime;

    private String order;



}
