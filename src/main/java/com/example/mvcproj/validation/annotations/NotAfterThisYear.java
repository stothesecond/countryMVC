package com.example.mvcproj.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotAfterThisYearValidator.class)
@Documented
public @interface NotAfterThisYear {
  String message() default "{constraints.field-match}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

  @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  @interface List
  {
    NotAfterThisYear[] value();
  }
}
