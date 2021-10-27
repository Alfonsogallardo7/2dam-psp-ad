package com.triana.salesianos.dam.E08Herencia.services;

import com.triana.salesianos.dam.E08Herencia.models.Empleado;
import com.triana.salesianos.dam.E08Herencia.repositories.EmpleadoRepository;
import com.triana.salesianos.dam.E08Herencia.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService extends BaseService <Empleado, Long, EmpleadoRepository> {
}
