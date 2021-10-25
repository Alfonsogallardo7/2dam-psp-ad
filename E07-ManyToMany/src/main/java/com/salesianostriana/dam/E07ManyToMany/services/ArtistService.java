package com.salesianostriana.dam.E07ManyToMany.services;

import com.salesianostriana.dam.E07ManyToMany.models.Artist;
import com.salesianostriana.dam.E07ManyToMany.repositories.ArtistRepository;
import com.salesianostriana.dam.E07ManyToMany.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ArtistService extends BaseService<Artist, Long, ArtistRepository> {
}
