package com.jc.controller;

import com.jc.param.FormatPojo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Date;

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
    public String init() {
        return "Formatter";
    }

    @RequestMapping("formatter")
    public ModelAndView format(@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date, @RequestParam("amount") @NumberFormat(pattern = "###,###.00") Double amount) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new MappingJackson2JsonView());
        modelAndView.addObject("date", date);
        modelAndView.addObject("amount", amount);
        return modelAndView;
    }


    @RequestMapping(value = "formatter",params = "pojo")
    public ModelAndView format1(FormatPojo pojo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new MappingJackson2JsonView());
        modelAndView.addObject("date", pojo.getDate1());
        modelAndView.addObject("amount", pojo.getAmount());
        return modelAndView;
    }

}
