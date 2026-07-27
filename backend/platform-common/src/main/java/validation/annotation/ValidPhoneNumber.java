package validation.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.RECORD_COMPONENT;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import validation.ValidationMessages;
import validation.validator.PhoneNumberValidator;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({
        FIELD,
        METHOD,
        PARAMETER,
        ANNOTATION_TYPE,
        RECORD_COMPONENT
})
@Retention(RUNTIME)
public @interface ValidPhoneNumber {

    String message() default ValidationMessages.INVALID_PHONE_NUMBER;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
