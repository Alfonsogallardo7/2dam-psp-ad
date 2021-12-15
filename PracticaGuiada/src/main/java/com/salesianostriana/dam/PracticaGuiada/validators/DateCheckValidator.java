package com.salesianostriana.dam.PracticaGuiada.validators;

import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateCheckValidator implements ConstraintValidator<DateCheck, Object> {

    private String fechaApertura;

    @Override
    public void initialize(DateCheck constraintAnnotation) {
        fechaApertura = constraintAnnotation.fechaApertura();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate fecha = (LocalDate) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(fechaApertura);
        return fecha.equals(LocalDate.now()) || fecha.isBefore(LocalDate.now());
    }
}
