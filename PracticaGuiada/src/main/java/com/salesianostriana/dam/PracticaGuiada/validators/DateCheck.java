package com.salesianostriana.dam.PracticaGuiada.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.*;

@Constraint(validatedBy = DateCheckValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateCheck {
    String message() default "{esatcionServicio.fecha.validate}";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] playload() default {};

    String fechaApertura();
    String fechaRegistro();
}
