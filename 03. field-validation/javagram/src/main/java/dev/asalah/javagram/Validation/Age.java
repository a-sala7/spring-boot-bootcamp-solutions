package dev.asalah.javagram.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
    String message() default "INVALID AGE";
    int minAge() default 0;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
