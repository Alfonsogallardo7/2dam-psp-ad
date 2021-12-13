package com.salesianostriana.dam.PracticaGuiada.services;

import com.salesianostriana.dam.PracticaGuiada.errors.exceptions.ListEntityNotFoundException;
import com.salesianostriana.dam.PracticaGuiada.errors.exceptions.SingleEntityNotFoundException;
import com.salesianostriana.dam.PracticaGuiada.models.EstacionServicio;
import com.salesianostriana.dam.PracticaGuiada.repositories.EstacionServicioRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstacionServicioService {

    private final EstacionServicioRepositories repositories;

    public List<EstacionServicio> findAll() {
        List<EstacionServicio> result = repositories.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(EstacionServicio.class);
        } else {
            return result;
        }
    }

    public EstacionServicio findById (Long id) {
        return repositories.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), EstacionServicio.class));
    }

    public EstacionServicio save (EstacionServicio estacionServicio) {
        return repositories.save(estacionServicio);
    }

    public EstacionServicio edit(EstacionServicio create, EstacionServicio e){
        e.setNombre(create.getNombre());
        e.setMarca(create.getMarca());
        e.setFechaApertura(create.getFechaApertura());
        e.setServicios(create.getServicios());
        e.setPrecioGasoilEspecial(create.getPrecioGasoilEspecial());
        e.setPrecioGasoilNormal(create.getPrecioGasoilNormal());
        e.setPrecioGasolina95(create.getPrecioGasolina95());
        e.setPrecioGasolina98(create.getPrecioGasolina98());
        e.setAutolavado(create.isAutolavado());
        e.setUbicacion(create.getUbicacion());
        return repositories.save(e);
    }

    public void deleteById(EstacionServicio e){
        repositories.delete(e);
    }
}
