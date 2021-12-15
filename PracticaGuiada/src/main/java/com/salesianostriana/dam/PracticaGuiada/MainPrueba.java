package com.salesianostriana.dam.PracticaGuiada;

import com.salesianostriana.dam.PracticaGuiada.models.EstacionServicio;
import com.salesianostriana.dam.PracticaGuiada.services.EstacionServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final EstacionServicioService service;

    @PostConstruct
    public void prueba () {
        EstacionServicio estacion1 = EstacionServicio.builder()
                .nombre("Estaciónn de San Juan de Aznalfarache")
                .marca("Repsol")
                .autolavado(true)
                .fechaApertura(LocalDate.of(2001,6,30))
                .precioGasoilNormal(1.234)
                .precioGasoilEspecial(1.345)
                .precioGasolina95(1.456)
                .precioGasolina98(1.567)
                .maps("-34.435 4.4534")
                .servicios("Gasolinera wena de san juan, al lao de la esquina del gato")
                .build();

        EstacionServicio estacion2 = EstacionServicio.builder()
                .nombre("Estaciónn de Ciudad Expo")
                .marca("BP")
                .autolavado(true)
                .fechaApertura(LocalDate.of(2003,6,30))
                .precioGasoilNormal(1.234)
                .precioGasoilEspecial(1.345)
                .precioGasolina95(1.456)
                .precioGasolina98(1.567)
                .maps("-34.435 4.4534")
                .servicios("Gasolinera wena de mairena, en ciudad expo al lado del metro")
                .build();

        service.save(estacion1);
        service.save(estacion2);

    }
}
