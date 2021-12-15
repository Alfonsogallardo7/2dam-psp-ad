package com.salesianostriana.dam.PracticaGuiada.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = LocatedCheckValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LocatedCheck {
    String message() default  "{estacionServicio.mapsEqual.validate}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String maps();
}
