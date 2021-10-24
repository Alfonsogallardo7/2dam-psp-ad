package com.salesianostriana.dam.E06Ejercicio2.services;

import com.salesianostriana.dam.E06Ejercicio2.model.Profesor;
import com.salesianostriana.dam.E06Ejercicio2.repositories.ProfesorRepository;
import com.salesianostriana.dam.E06Ejercicio2.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService extends BaseService<Profesor, Long, ProfesorRepository> {
}
