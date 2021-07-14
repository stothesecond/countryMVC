package com.example.mvcproj.validation.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class NotAfterThisYearValidator implements ConstraintValidator<NotAfterThisYear, Integer> {
  @Override
  public void initialize(NotAfterThisYear constraintAnnotation) {
  }

  @Override
  public boolean isValid(final Integer year, final ConstraintValidatorContext context) {
    return year <= Calendar.getInstance().get(Calendar.YEAR);
  }
}
