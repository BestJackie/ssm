package com.jc.validator;

import com.jc.param.ValidationParams;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * FileName: ValidationParamValidator
 *
 * @author: haichaoyang3
 * @date: 2020/7/13 10:31
 * Description:
 * History:
 * since: 1.0.0
 */

public class ValidationParamValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return ValidationParams.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
    }
}
