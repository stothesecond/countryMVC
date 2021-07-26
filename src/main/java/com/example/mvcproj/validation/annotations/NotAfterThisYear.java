package com.example.mvcproj.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.mvcproj.validation.NotAfterThisYearValidator;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotAfterThisYearValidator.class)
@Documented
public @interface NotAfterThisYear {
  String message() default "Cannot be after this year.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
