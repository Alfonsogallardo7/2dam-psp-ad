package com.salesianostriana.dam.validacion.simple.validadores;

import com.salesianostriana.dam.validacion.simple.anotaciones.StrongPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator <StrongPassword, String> {

    private int min;
    private int max;
    private boolean hasUpper;
    private boolean hasLower;
    private boolean hasNumber;
    private boolean hasAlpha;
    private boolean hasOther;

    @Override
    public void initialize(StrongPassword constraintAnnotation) {
    min = constraintAnnotation.min();
    max = constraintAnnotation.max();
    hasUpper = constraintAnnotation.hasUpper();
    hasLower = constraintAnnotation.hasLower();
    hasAlpha = constraintAnnotation.hasAlpha();
    hasNumber = constraintAnnotation.hasNumber();
    hasOther = constraintAnnotation.hasAlpha();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password.length()<min || password.length()>max) {
            return false;
        }

        if (hasUpper) {
            if (password.equals(password.toLowerCase()));
            return false;
        }

        if (hasLower) {
            if (password.equals(password.toUpperCase()));
        }

        if (hasNumber) {
            if (!password.matches(".*[0-9].*"))
                return false;
        }

        if (hasAlpha){
            if (!password.matches(".*[a-z].*"))
                return false;
        }

        if (hasOther) {
            if (!(password.contains(".") || password.contains(",") || password.contains("$")
            || password.contains("-") || password.contains("_"))) {
                return false;
            }
        }
        return true;
    }
}
