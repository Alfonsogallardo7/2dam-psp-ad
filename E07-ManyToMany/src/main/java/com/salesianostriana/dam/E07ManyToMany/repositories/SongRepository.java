package com.salesianostriana.dam.E07ManyToMany.repositories;

import com.salesianostriana.dam.E07ManyToMany.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
