package com.salesianostriana.dam.PracticaGuiada.controller;

import com.salesianostriana.dam.PracticaGuiada.models.EstacionServicio;
import com.salesianostriana.dam.PracticaGuiada.services.EstacionServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacion_servicio")
public class EstacionServicioController {

    private final EstacionServicioService service;

    @GetMapping("/")
    public List<EstacionServicio> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EstacionServicio findById(@PathVariable Long id) {return service.findById(id);}

    @PutMapping("/{id}")
    public EstacionServicio edit(@Valid @RequestBody EstacionServicio es, EstacionServicio e){
        return service.edit(es, e);
    }

    @DeleteMapping("/{id}")
    public void delete(EstacionServicio e){
        service.deleteById(e);
    }
}
