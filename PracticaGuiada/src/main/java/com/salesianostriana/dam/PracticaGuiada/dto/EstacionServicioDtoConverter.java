package com.salesianostriana.dam.PracticaGuiada.dto;

import com.salesianostriana.dam.PracticaGuiada.models.EstacionServicio;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EstacionServicioDtoConverter {

    public EstacionServicio estacionServicioDtoToEstacionServicio(CreateEstacionServicioDto dto) {
        return EstacionServicio.builder()
                .nombre(dto.getNombre())
                .marca(dto.getMarca())
                .maps(dto.getMaps())
                .precioGasoilNormal(dto.getPrecioGasoilNormal())
                .precioGasoilEspecial(dto.getPrecioGasoilEspecial())
                .precioGasolina95(dto.getPrecioGasolina95())
                .precioGasolina98(dto.getPrecioGasolina98())
                .fechaApertura(LocalDate.now())
                .fechaApertura(dto.getFechaApertura())
                .build();
    }

    public CreateEstacionServicioDto estacionServicioToEstacionServicioDto(EstacionServicio estacionServicio) {
        return CreateEstacionServicioDto.builder()
                .nombre(estacionServicio.getNombre())
                .marca(estacionServicio.getMarca())
                .maps(estacionServicio.getMaps())
                .precioGasoilNormal(estacionServicio.getPrecioGasoilNormal())
                .precioGasoilEspecial(estacionServicio.getPrecioGasoilEspecial())
                .precioGasolina95(estacionServicio.getPrecioGasolina95())
                .precioGasolina98(estacionServicio.getPrecioGasolina98())
                .fechaApertura(estacionServicio.getFechaApertura())
                .build();
    }
}
