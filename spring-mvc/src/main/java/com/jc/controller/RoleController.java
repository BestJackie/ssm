package com.jc.controller;

import com.jc.pojo.Role;
import com.jc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * FileName: RoleController
 *
 * @author: haichaoyang3
 * @date: 2020/7/8 11:42
 * Description:
 * History:
 * since: 1.0.0
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @GetMapping("getRole")
    public ModelAndView getRole(@RequestParam(value = "id",defaultValue = "1") Integer id){
        Role role =roleService.getRole(id);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("roleDetails");
        mv.addObject("role",role);
        return mv;
    }
    @GetMapping(value = "getRole", params = "json")
    public ModelAndView getJsonRole(@RequestParam(value = "id",defaultValue = "1") Integer id){
        Role role =roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.setView(new MappingJackson2JsonView());
        return mv;

    }

}
