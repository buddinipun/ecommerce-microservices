package validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validation.annotation.ValidPhoneNumber;

public class PhoneNumberValidator
        implements ConstraintValidator<ValidPhoneNumber, String> {

    private static final String PHONE_PATTERN =
            "^\\+?[1-9]\\d{7,14}$";

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context
    ) {

        if (value == null || value.isBlank()) {
            return true;
        }

        return value.matches(PHONE_PATTERN);

    }

}