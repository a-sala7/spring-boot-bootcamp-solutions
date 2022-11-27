package dev.asalah.javagram.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("[^a-z0-9]");
        Matcher matcher = pattern.matcher(username);
        boolean hasInvalidCharacters = matcher.find();
        return !hasInvalidCharacters;
    }
}
