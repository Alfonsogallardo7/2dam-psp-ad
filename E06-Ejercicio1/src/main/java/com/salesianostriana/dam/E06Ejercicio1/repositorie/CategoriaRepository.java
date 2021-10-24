package com.salesianostriana.dam.E06Ejercicio1.repositorie;

import com.salesianostriana.dam.E06Ejercicio1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
}
