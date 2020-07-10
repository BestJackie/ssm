package com.jc.controller;

import com.jc.param.RoleParams;
import com.jc.pojo.Role;
import com.jc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.List;

/**
 * FileName: ParamController
 *
 * @author: haichaoyang3
 * @date: 2020/7/9 10:00
 * Description:
 * History:
 * since: 1.0.0
 */
@Controller
@RequestMapping("params")
public class ParamController {

    @Autowired
    private RoleService roleService;

    @GetMapping("init")
    public ModelAndView init() {
        return new ModelAndView("params");
    }

    @RequestMapping("common")
    public ModelAndView commonParam(String roleName, String note) throws UnsupportedEncodingException {
        System.out.println("roleName=>" +convert(roleName) );
        System.out.println("note=>" + convert(note));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    private String convert(String s) throws UnsupportedEncodingException {
        return new String(s.getBytes("iso8859-1"),"utf-8");
    }

    @GetMapping(value = "common",params = "pojo")
    public ModelAndView commonParamPojo(RoleParams roleParams) throws UnsupportedEncodingException {
        System.out.println("pojo");
        System.out.println("roleName=>" + roleParams.getRoleName());
        System.out.println("note=>" + roleParams.getNote());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }


    @PostMapping(value = "common", params = "json")
    public ModelAndView jsonReq(@RequestBody RoleParams roleParams){
        System.out.println("json");
        System.out.println("roleName=>" + roleParams.getRoleName());
        System.out.println("note=>" + roleParams.getNote());
        System.out.println("start=>" + roleParams.getPageParam().getStart());
        System.out.println("limit=>" + roleParams.getPageParam().getLimit());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }


    @PostMapping(value = "addRoles")
    public ModelAndView addRoles(@RequestBody List<Role> roleList){
        int total =roleService.addRoles(roleList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("total",total);
        mv.setView(new MappingJackson2JsonView());
        return mv;

    }


    @GetMapping(value = "roleInfo")
    public ModelAndView showRoleInfo(Integer id,String roleName,String note){
        ModelAndView mv = new ModelAndView();
        mv.addObject("id",id);
        mv.addObject("roleName",roleName);
        mv.addObject("note",note);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }


    @GetMapping(value = "addRole")
    public String addRole(Model model, String roleName, String note){
        Role role = new Role();
        role.setRoleName(roleName);
        role.setNote(note);
        roleService.addRole(role);

        model.addAttribute("id",role.getId());
        model.addAttribute("roleName",roleName);
        model.addAttribute("note",note);
        return "redirect:./roleInfo";
    }

}
