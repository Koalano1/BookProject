package com.example.demo.validation;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.logging.log4j.util.Strings;

public class NullOrBlankValidation  implements ConstraintValidator<NullOrBlank, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return Objects.isNull(value) || Strings.isNotBlank(value);
	}

}
