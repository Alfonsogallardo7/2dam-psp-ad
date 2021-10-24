package com.salesianostriana.dam.E06Ejercicio1.services;

import com.salesianostriana.dam.E06Ejercicio1.model.Categoria;
import com.salesianostriana.dam.E06Ejercicio1.repositorie.CategoriaRepository;
import com.salesianostriana.dam.E06Ejercicio1.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService <Categoria, Long, CategoriaRepository> {
}
