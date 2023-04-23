package com.example.demo.validation;

import java.util.Locale.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class bookCategoryValidation implements ConstraintValidator<bookCategory, Category> {

	@Override
	public boolean isValid(Category value, ConstraintValidatorContext context) {
		
		return false;
	}

	
	/*
	 * private List<String> validCategories = Arrays.asList("fiction",
	 * "non-fiction", "science-fiction");
	 * 
	 * public void initialize(ValidCategory constraintAnnotation) {}
	 * 
	 * @Override public boolean isValid(String value, ConstraintValidatorContext
	 * context) { return validCategories.contains(value.toLowerCase()); }
	 */
}
