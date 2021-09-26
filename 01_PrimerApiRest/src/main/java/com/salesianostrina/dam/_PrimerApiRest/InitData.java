package com.salesianostrina.dam._PrimerApiRest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class InitData {

    private final TaskRepository repository;


    @PostConstruct
    public void init(){
        repository.saveAll(
                Arrays.asList(
                        new Task( "Rellenar el initdata",  "Llena de datos el repositorio"),
                        new Task( "Programar", "Y programar, y programar")
                )
        );
    }
}
