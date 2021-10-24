package com.salesianostriana.dam.E06Ejercicio2.services;

import com.salesianostriana.dam.E06Ejercicio2.model.Video;
import com.salesianostriana.dam.E06Ejercicio2.repositories.VideoRepository;
import com.salesianostriana.dam.E06Ejercicio2.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class VideoService extends BaseService<Video, Long, VideoRepository> {
}
