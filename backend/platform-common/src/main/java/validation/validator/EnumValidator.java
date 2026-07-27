package validation.validator;

import java.util.Arrays;

import enums.common.LookupEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validation.annotation.ValidEnum;

public class EnumValidator implements ConstraintValidator<ValidEnum, String> {

private Class<? extends Enum<?>> enumClass;

@Override
public void initialize(
    ValidEnum annotation
) {

this.enumClass = annotation.enumClass();

}

@Override
public boolean isValid(
    String value,
    ConstraintValidatorContext context
) {

if (value == null || value.isBlank()) {
    return true;
}

if (!LookupEnum.class.isAssignableFrom(enumClass)) {
    return false;
}

return Arrays.stream(enumClass.getEnumConstants())
        .map(enumValue -> (LookupEnum) enumValue)
        .anyMatch(lookupEnum ->
                lookupEnum.getCode()
                        .equalsIgnoreCase(value)
        );

}
}
