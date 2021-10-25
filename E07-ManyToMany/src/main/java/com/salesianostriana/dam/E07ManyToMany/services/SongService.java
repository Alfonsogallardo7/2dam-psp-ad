package com.salesianostriana.dam.E07ManyToMany.services;

import com.salesianostriana.dam.E07ManyToMany.models.Song;
import com.salesianostriana.dam.E07ManyToMany.repositories.SongRepository;
import com.salesianostriana.dam.E07ManyToMany.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SongService extends BaseService<Song, Long, SongRepository> {
}
