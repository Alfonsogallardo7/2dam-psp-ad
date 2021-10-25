package com.salesianostriana.dam.E07ManyToMany.repositories;

import com.salesianostriana.dam.E07ManyToMany.models.AddedTo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddedToRepository extends JpaRepository<AddedTo, Long> {
}
