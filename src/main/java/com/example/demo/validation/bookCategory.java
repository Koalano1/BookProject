package com.example.demo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {CheckDayValidation.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface bookCategory {
	
	String message() default "Hay nhap dung kieu!";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
