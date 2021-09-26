package com.salesianostriana.dam._Ejercicio_Practico;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentoController {

    public final MonumentoRepository repository;

    @GetMapping("/")
    public List<Monumento> findAll(){
        return repository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(monumento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.status(204).build;
    }

    @PutMapping("/{id}")
    public Monumento edit (@RequestBody Monumento monumento, @PathVariable Long id) {
        Monumento antigua = repository.findById(id).orElse(monumento);
        antigua.setCodigoPais(monumento.getCodigoPais());
        antigua.setNombrePais(monumento.getNombrePais());
        antigua.setNombreCiudad(monumento.getNombreCiudad());
        antigua.setAltitud(monumento.getAltitud());
        antigua.setLatitud(monumento.getLatitud());
        antigua.setNombreMonumento(monumento.getNombreMonumento());
        antigua.setDescripcion(monumento.getDescripcion());
        antigua.setUrlFoto(monumento.getUrlFoto());

        return repository.save(antigua);
    }

    @GetMapping("/{id}")
    public Monumento findOne (@PathVariable("id")Long id){
        return repository.findById(id).orElse(null);
    }
}
