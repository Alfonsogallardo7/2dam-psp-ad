package com.salesianostriana.dam.PracticaGuiada.dto;

import com.salesianostriana.dam.PracticaGuiada.validators.DateCheck;
import com.salesianostriana.dam.PracticaGuiada.validators.LocatedCheck;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@DateCheck(fechaApertura = "fechaApertura", fechaRegistro = "fechaRegistro", message = "{estacionServicio.fecha.validate}")
public class CreateEstacionServicioDto {

    @NotBlank(message = "{estacionServicio.nombre.blank}")
    private String nombre;

    private String marca;

    @Pattern(
            regexp = "^(\\-?\\d+(\\.\\d+)?),\\w*(\\-?\\d+(\\.\\d+)?)$",
            message = "{estacionServicio.maps.validate}")
    @LocatedCheck(maps = "maps", message = "{estacionServicio.mapsEqual.validate}")
    private String maps;

    @PositiveOrZero(message = "{estacionServicio.precio.min}")
    @NotNull(message = "{estacionServicio.precio.null}")
    private double precioGasoilNormal;

    @PositiveOrZero(message = "{estacionServicio.precio.min}")
    @NotNull(message = "{estacionServicio.precio.null}")
    private double precioGasoilEspecial;

    @PositiveOrZero(message = "{estacionServicio.precio.min}")
    @NotNull(message = "{estacionServicio.precio.null}")
    private double precioGasolina95;

    @PositiveOrZero(message = "{estacionServicio.precio.min}")
    @NotNull(message = "{estacionServicio.precio.null}")
    private double precioGasolina98;

    @Past
    private LocalDate fechaApertura;


}
