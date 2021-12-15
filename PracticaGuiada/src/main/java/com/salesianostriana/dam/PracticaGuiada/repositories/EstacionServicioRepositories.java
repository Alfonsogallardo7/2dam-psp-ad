package com.salesianostriana.dam.PracticaGuiada.repositories;

import com.salesianostriana.dam.PracticaGuiada.models.EstacionServicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionServicioRepositories extends JpaRepository<EstacionServicio, Long> {
    boolean existsByMaps(String maps);
}
