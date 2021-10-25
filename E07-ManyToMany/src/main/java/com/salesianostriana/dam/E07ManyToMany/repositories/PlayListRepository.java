package com.salesianostriana.dam.E07ManyToMany.repositories;

import com.salesianostriana.dam.E07ManyToMany.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListRepository extends JpaRepository<Playlist, Long> {
}
