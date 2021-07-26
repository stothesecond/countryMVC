package com.example.mvcproj.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.mvcproj.validation.annotations.PasswordMatches;
import com.example.mvcproj.validation.dto.UserRegistrationDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
  @Override
  public void initialize(PasswordMatches constraintAnnotation) {
  }

  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context) {
    UserRegistrationDto user = (UserRegistrationDto) obj;
    return user.getPassword().equals(user.getConfirmPass());
  }
}
