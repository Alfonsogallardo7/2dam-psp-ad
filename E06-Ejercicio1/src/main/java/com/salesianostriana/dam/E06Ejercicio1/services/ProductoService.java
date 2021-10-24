package com.salesianostriana.dam.E06Ejercicio1.services;

import com.salesianostriana.dam.E06Ejercicio1.model.Producto;
import com.salesianostriana.dam.E06Ejercicio1.repositorie.ProductoRepository;
import com.salesianostriana.dam.E06Ejercicio1.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProductoService extends BaseService<Producto, Long, ProductoRepository> {
}
