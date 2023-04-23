package com.example.demo.validation;

import java.sql.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDayValidation implements ConstraintValidator<CheckDay, Date>{

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		long currentDay = System.currentTimeMillis();
		Date date = new Date(currentDay);
		if(value.compareTo(date) > 0) {
			return false;
		}else {
			return true;
		}
	}

}

