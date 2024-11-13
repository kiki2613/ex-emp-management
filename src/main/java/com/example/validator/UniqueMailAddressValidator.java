package com.example.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.service.AdministratorService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * メールアドレスの重複をチェックするバリデータクラス.
 * 
 * @author M.aoki
 */
public class UniqueMailAddressValidator implements ConstraintValidator<UniqueMailAddress, String> {

  @Autowired
  private AdministratorService administratorService;

  @Override
  public void initialize(UniqueMailAddress constraintAnnotation) {

  }

  public boolean isValid(String mailAddress, ConstraintValidatorContext context) {
    if (mailAddress == null || mailAddress.isEmpty()) {
      return true;
    }

    return !administratorService.isMailAddressRegistered(mailAddress);
  }

}
