package com.salesianostriana.dam.E06Ejercicio1.repositorie;

import com.salesianostriana.dam.E06Ejercicio1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto, Long>{
}
