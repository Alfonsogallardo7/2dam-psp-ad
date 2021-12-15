package com.salesianostriana.dam.PracticaGuiada.services;

import com.salesianostriana.dam.PracticaGuiada.dto.CreateEstacionServicioDto;
import com.salesianostriana.dam.PracticaGuiada.dto.EstacionServicioDtoConverter;
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
    private final EstacionServicioDtoConverter estacionServicioDtoConverter;

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

    public EstacionServicio save1 (CreateEstacionServicioDto dto) {
        return repositories.save(estacionServicioDtoConverter.estacionServicioDtoToEstacionServicio(dto));
    }

    public EstacionServicio save (EstacionServicio estacionServicio) {
        return repositories.save(estacionServicio);
    }

    public EstacionServicio edit(Long id, CreateEstacionServicioDto dto){
        return repositories.findById(id).map(e->{
                    e.setNombre(dto.getNombre());
                    e.setMarca(dto.getMarca());
                    e.setMaps(dto.getMaps());
                    e.setPrecioGasoilNormal(dto.getPrecioGasoilNormal());
                    e.setPrecioGasoilEspecial(dto.getPrecioGasoilEspecial());
                    e.setPrecioGasolina95(dto.getPrecioGasolina95());
                    e.setPrecioGasolina98(dto.getPrecioGasolina98());
                    e.setFechaApertura(dto.getFechaApertura());
                    repositories.save(e);
                    return e;
                })
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), EstacionServicio.class));
    }

    public void deleteById(Long id){
        repositories.findById(id)
                .orElseThrow(()-> new SingleEntityNotFoundException(id.toString(), EstacionServicio.class));
        if (repositories.findById(id)!=null) {
            repositories.deleteById(id);
        }
    }
}
