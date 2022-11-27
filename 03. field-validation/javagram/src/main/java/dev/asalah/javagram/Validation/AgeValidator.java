package dev.asalah.javagram.Validation;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Date> {

    private int minAge;

    @Override
    public void initialize(Age parameters) {
        minAge = parameters.minAge();
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {

        long diff = (new Date()).getTime() - date.getTime();
        int age = (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);
        return age >= minAge;
    }
    
}
