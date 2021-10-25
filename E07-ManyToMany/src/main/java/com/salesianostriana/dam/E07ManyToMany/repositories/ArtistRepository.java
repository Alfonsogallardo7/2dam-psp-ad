package com.salesianostriana.dam.E07ManyToMany.repositories;

import com.salesianostriana.dam.E07ManyToMany.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository <Artist, Long> {
}
