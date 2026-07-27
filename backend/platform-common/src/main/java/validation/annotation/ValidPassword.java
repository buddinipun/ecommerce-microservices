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
import validation.validator.PasswordValidator;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({
        FIELD,
        METHOD,
        PARAMETER,
        ANNOTATION_TYPE,
        RECORD_COMPONENT
})
@Retention(RUNTIME)
public @interface ValidPassword {

    String message() default ValidationMessages.INVALID_PASSWORD;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minLength() default 8;

    int maxLength() default 100;

    boolean requireUppercase() default true;

    boolean requireLowercase() default true;

    boolean requireDigit() default true;

    boolean requireSpecialCharacter() default true;

}
