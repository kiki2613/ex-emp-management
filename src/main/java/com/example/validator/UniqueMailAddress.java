package com.example.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * メールアドレスの重複をチェックするアノテーション.
 * 
 * @author M.aoki
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueMailAddressValidator.class)
public @interface UniqueMailAddress {
  String message() default "このメールアドレスは既に登録されています";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
