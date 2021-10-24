package com.salesianostriana.dam.E06Ejercicio1;

import com.salesianostriana.dam.E06Ejercicio1.model.Categoria;
import com.salesianostriana.dam.E06Ejercicio1.model.Producto;
import com.salesianostriana.dam.E06Ejercicio1.services.CategoriaService;
import com.salesianostriana.dam.E06Ejercicio1.services.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class MainPrueba {
    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    @PostConstruct
    public void test() {
        Producto p1 = new Producto("Cruzcampo", 125.50);
        productoService.save(p1);

        Categoria c1 = Categoria.builder()
                .nombre("Bebidas Alcoholicas")
                .build();
        categoriaService.save(c1);

        p1.addCategoria(c1);
        productoService.save(p1);

        System.out.printf("%s, %s\n", p1.getNombre(), p1.getCategoria().getNombre());
    }
}
