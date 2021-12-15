package com.salesianostriana.dam.PracticaGuiada.validators;

import com.salesianostriana.dam.PracticaGuiada.repositories.EstacionServicioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocatedCheckValidator implements ConstraintValidator <LocatedCheck, String> {

    private String maps;

    @Autowired
    private EstacionServicioRepositories estacionServicioRepositories;

    @Override
    public void initialize(LocatedCheck constraintAnnotation) {
        maps = constraintAnnotation.maps();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !estacionServicioRepositories.existsByMaps(s);
    }
}
