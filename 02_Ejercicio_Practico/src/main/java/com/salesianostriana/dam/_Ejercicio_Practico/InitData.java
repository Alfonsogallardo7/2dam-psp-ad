package com.salesianostriana.dam._Ejercicio_Practico;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class InitData {

    private final MonumentoRepository repository;

    @PostConstruct
    public void init(){
        repository.saveAll(
                Arrays.asList(
                        new Monumento("ISO 1655-5 alfa 2", "Brazil", "Rio de Janeiro", "22°57′08″S", "43°12′37″O",
                                "Cristo Redentor", "Gran monumento de Brazil", "http://cristo_redentor.com" ),
                        new Monumento("ISO 6514-7 alfa 2", "Italia", "Roma", "22°57′08″S", "43°12′37″O",
                                "Colisseo Romano", "Gran monumento Romano", "http://colisseo_Romano.com" ),
                )
        );
    }
}
