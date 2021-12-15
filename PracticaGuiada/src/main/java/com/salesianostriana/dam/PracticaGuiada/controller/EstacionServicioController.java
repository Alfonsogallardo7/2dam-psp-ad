package com.salesianostriana.dam.PracticaGuiada.controller;

import com.salesianostriana.dam.PracticaGuiada.dto.CreateEstacionServicioDto;
import com.salesianostriana.dam.PracticaGuiada.dto.EstacionServicioDtoConverter;
import com.salesianostriana.dam.PracticaGuiada.models.EstacionServicio;
import com.salesianostriana.dam.PracticaGuiada.services.EstacionServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacion_servicio")
public class EstacionServicioController {

    private final EstacionServicioService service;
    private final EstacionServicioDtoConverter estacionServicioDtoConverter;

    @GetMapping("/")
    public List<EstacionServicio> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EstacionServicio findById(@PathVariable @Min(value = 0, message = "El identificador no puede ser negativo") Long id) {
        return service.findById(id);}

    @PostMapping("/")
    public EstacionServicio crear(@Valid @RequestBody CreateEstacionServicioDto dto) {
        return service.save1(dto);
    }

    @PutMapping("/{id}")
    public EstacionServicio edit(@PathVariable Long id, @Valid @RequestBody CreateEstacionServicioDto dto){
        return service.edit(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        service.deleteById(id);
    }
}
