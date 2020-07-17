package com.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * FileName: FormatterController
 *
 * @author: haichaoyang3
 * @date: 2020/7/15 14:47
 * Description:
 * History:
 * since: 1.0.0
 */
@Controller
@RequestMapping("converter")
public class FormatterController {
    @GetMapping("index")
    public String init(){
        return "Formatter";
    }

    /*@RequestMapping("formatter")
    public ModelAndView format(@RequestParam("")){

    }*/

}
