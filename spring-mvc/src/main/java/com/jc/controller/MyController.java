package com.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * FileName: MyController
 *
 * @author: haichaoyang3
 * @date: 2020/7/7 14:49
 * Description:
 * History:
 * since: 1.0.0
 */
@Controller
public class MyController {

    @GetMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
