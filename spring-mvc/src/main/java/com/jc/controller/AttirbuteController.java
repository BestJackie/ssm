package com.jc.controller;

import com.jc.pojo.Role;
import com.jc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * FileName: AttirbuteController
 *
 * @author: haichaoyang3
 * @date: 2020/7/10 10:27
 * Description: 主要是@RequestAttribute，@SessionAttributes，@SessionAttribute
 * History:
 * since: 1.0.0
 */
@Controller
@RequestMapping("attribute")
public class AttirbuteController {

    @Autowired
    private RoleService roleService;
    @GetMapping("init")
    public ModelAndView init (){
        ModelAndView mv = new ModelAndView();
       mv.setViewName("attribute");
        return mv;
    }

    @RequestMapping(value = "reqAttribute")
    public ModelAndView reqAttribute (@RequestAttribute Integer id){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("role",role);
        return mv;
    }
}
