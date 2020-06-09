package com.springboot.validator.bean;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanValidator {
  public static <T> void validate(T object) {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
    if (CollectionUtils.isEmpty(constraintViolations)) {
      return;
    }
    throw new ValidationException(convertErrorMsg(constraintViolations));
  }

  /**
   * 校验对象
   *
   * @param t bean
   * @param groups 校验组
   * @return ValidResult
   */
  public static <T> void validate(T object, Class<?>... groups) {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, groups);
    if (CollectionUtils.isEmpty(constraintViolations)) {
      return;
    }
    throw new ValidationException(convertErrorMsg(constraintViolations));
  }

  private static <T> String convertErrorMsg(Set<ConstraintViolation<T>> set) {
    Map<String, StringBuilder> errorMap = new HashMap<>();
    String property;
    for (ConstraintViolation<T> cv : set) {
      property = cv.getPropertyPath().toString();
      if (errorMap.get(property) != null) {
        errorMap.get(property).append("," + cv.getMessage());
      } else {
        StringBuilder sb = new StringBuilder();
        sb.append(cv.getMessage());
        errorMap.put(property, sb);
      }
    }
    return errorMap.toString();
  }
}
