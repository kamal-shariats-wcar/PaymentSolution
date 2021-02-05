package com.mydigipay.paymentService.annotation;


import com.mydigipay.paymentService.util.LengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Length {
  String message() default "error.invalid.length.characters";
  int min() default 0;

  int max() default 2147483647;

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
