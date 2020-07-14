package com.jc.controller;

import com.jc.param.ValidationParams;
import com.jc.validator.ValidationParamValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * FileName: ValidationController
 *
 * @author: haichaoyang3
 * @date: 2020/7/13 9:56
 * Description:
 * History:
 * since: 1.0.0
 */
@Controller
@RequestMapping("validation")
public class ValidationController {

    @InitBinder
    public void initBinder(DataBinder dataBinder){
        dataBinder.setValidator(new ValidationParamValidator());
    }

    @GetMapping("init")
    public ModelAndView init() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("validation");
        return modelAndView;
    }

    @RequestMapping("annotation")
    public ModelAndView annotationValidation(@Valid ValidationParams params, Errors errors) {

        if (errors.hasErrors()) {
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError fieldError : errorList) {
                System.out.println("filed :" + fieldError.getField() + "\t" + "msg: " + fieldError.getDefaultMessage());
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;


    }


}
