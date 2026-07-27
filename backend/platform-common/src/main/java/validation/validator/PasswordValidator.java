package validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validation.annotation.ValidPassword;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private int minLength;

    private int maxLength;

    private boolean requireUppercase;

    private boolean requireLowercase;

    private boolean requireDigit;

    private boolean requireSpecialCharacter;

    @Override
    public void initialize(
            ValidPassword annotation
    ) {

        this.minLength = annotation.minLength();

        this.maxLength = annotation.maxLength();

        this.requireUppercase =
                annotation.requireUppercase();

        this.requireLowercase =
                annotation.requireLowercase();

        this.requireDigit =
                annotation.requireDigit();

        this.requireSpecialCharacter =
                annotation.requireSpecialCharacter();

    }

    @Override
    public boolean isValid(
            String password,
            ConstraintValidatorContext context
    ) {

        if (password == null) {
            return true;
        }

        if (password.length() < minLength
                || password.length() > maxLength) {

            return false;
        }

        if (requireUppercase
                && !password.matches(".*[A-Z].*")) {

            return false;
        }

        if (requireLowercase
                && !password.matches(".*[a-z].*")) {

            return false;
        }

        if (requireDigit
                && !password.matches(".*\\d.*")) {

            return false;
        }

        if (requireSpecialCharacter
                && !password.matches(
                ".*[^a-zA-Z0-9].*"
        )) {

            return false;
        }

        return true;
    }

}
