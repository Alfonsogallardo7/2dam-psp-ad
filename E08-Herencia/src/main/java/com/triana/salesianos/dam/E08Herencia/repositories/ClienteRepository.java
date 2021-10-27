package com.triana.salesianos.dam.E08Herencia.repositories;

import com.triana.salesianos.dam.E08Herencia.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente,Long> {
}
