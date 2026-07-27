package validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import util.UuidUtil;
import validation.annotation.ValidUuid;

public class UuidValidator implements ConstraintValidator<ValidUuid, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		/*
		 * Null and blank values are considered valid here.
		 *
		 * @NotNull or @NotBlank should be used when the field itself is mandatory.
		 */
		if (value == null || value.isBlank()) {
			return true;
		}

		return UuidUtil.isValid(value);
	}

}