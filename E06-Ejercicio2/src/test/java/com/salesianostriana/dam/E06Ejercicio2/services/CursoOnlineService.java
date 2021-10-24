package com.salesianostriana.dam.E06Ejercicio2.services;

import com.salesianostriana.dam.E06Ejercicio2.model.CursoOnline;
import com.salesianostriana.dam.E06Ejercicio2.repositories.CursoOnlineRepository;
import com.salesianostriana.dam.E06Ejercicio2.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CursoOnlineService extends BaseService<CursoOnline
        , Long, CursoOnlineRepository> {
}
