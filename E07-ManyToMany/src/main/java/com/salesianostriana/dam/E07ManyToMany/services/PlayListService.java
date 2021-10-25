package com.salesianostriana.dam.E07ManyToMany.services;

import com.salesianostriana.dam.E07ManyToMany.models.Playlist;
import com.salesianostriana.dam.E07ManyToMany.repositories.PlayListRepository;
import com.salesianostriana.dam.E07ManyToMany.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PlayListService extends BaseService<Playlist, Long, PlayListRepository> {
}
