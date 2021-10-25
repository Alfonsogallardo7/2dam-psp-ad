package com.salesianostriana.dam.E07ManyToMany;

import com.salesianostriana.dam.E07ManyToMany.models.Artist;
import com.salesianostriana.dam.E07ManyToMany.models.Playlist;
import com.salesianostriana.dam.E07ManyToMany.models.Song;
import com.salesianostriana.dam.E07ManyToMany.services.AddedToService;
import com.salesianostriana.dam.E07ManyToMany.services.ArtistService;
import com.salesianostriana.dam.E07ManyToMany.services.PlayListService;
import com.salesianostriana.dam.E07ManyToMany.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final SongService songService;
    private final PlayListService playlistService;
    private final ArtistService artistService;
    private final AddedToService addedToService;

    @PostConstruct
    public void test() {

        Artist artist = Artist.builder()
                .name("Los delincuentes")
                .build();

        artistService.edit(artist);


        Song song = Song.builder()
                .tittle("Aire de la calle")
                .artists(artist)
                .build();

        songService.save(song);
        song.addArtist(artist);


        Playlist playlist = Playlist.builder()
                .name("PlayList garrapatera, musica de verdad")
                .build();

        playlistService.save(playlist);
        playlist.addSong(song);

        playlistService.edit(playlist);


        System.out.println("La playList: " + playlist.getName() +
                ", tiene la canción " + playlist.getSongs().get(0).getTittle() +
                " y el artista es: " + playlist.getSongs().get(0).getArtists().getName());
    }
}
