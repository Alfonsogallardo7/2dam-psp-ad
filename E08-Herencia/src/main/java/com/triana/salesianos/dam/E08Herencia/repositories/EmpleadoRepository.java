package com.triana.salesianos.dam.E08Herencia.repositories;

import com.triana.salesianos.dam.E08Herencia.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository <Empleado,Long> {
}
