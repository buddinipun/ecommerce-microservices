package validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import validation.ValidationMessages;
import validation.validator.UuidValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.RECORD_COMPONENT;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UuidValidator.class)
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, RECORD_COMPONENT })
@Retention(RUNTIME)
public @interface ValidUuid {

	String message() default ValidationMessages.INVALID_UUID;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
