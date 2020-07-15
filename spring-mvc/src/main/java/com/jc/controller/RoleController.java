package com.jc.controller;

import com.jc.excel.ExcelExportService;
import com.jc.excel.ExcelView;
import com.jc.pojo.Role;
import com.jc.service.RoleService;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

   /* @GetMapping("getRole")
    public ModelAndView getRole(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        Role role = roleService.getRole(id);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("roleDetails");
        mv.addObject("role", role);
        return mv;
    }*/


    @GetMapping("getRole")
    @ResponseBody
    public Role getRole(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        return roleService.getRole(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public Map updateRole(Role role) {
        Map<String, String> result = new HashMap<>(1);
        boolean flag = roleService.updateRole(role) == 1;
        if (flag)
            result.put("msg","success");
        else
            result.put("msg","fail");
        return result;

    }

    @GetMapping(value = "getRole", params = "json")
    public ModelAndView getJsonRole(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.setView(new MappingJackson2JsonView());
        return mv;

    }

    @GetMapping(value = "getRole/{id}", params = "json")
    public ModelAndView getJsonRoleByPath(@PathVariable(value = "id") Integer id) {
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.setView(new MappingJackson2JsonView());
        return mv;

    }


    @GetMapping("index")
    public String index(@RequestParam(value = "id", defaultValue = "1") Integer id, ModelMap modelMap) {
        Role role = roleService.getRole(id);
        modelMap.addAttribute("role", role);
        return "roleDetails";
    }

    @GetMapping("export")
    public ModelAndView export() {
        ModelAndView mv = new ModelAndView();
        ExcelView ev = new ExcelView(exportService());
        ev.setFileName("所有角色.xls");
        List<Role> roleList = roleService.getAllRoles();
        mv.addObject("roleList", roleList);
        mv.setView(ev);
        return mv;
    }

    private ExcelExportService exportService() {
        return (model, wookbook) -> {
            List<Role> roleList = (List<Role>) model.get("roleList");
            Sheet sheet = wookbook.createSheet("all roles");
            Row title = sheet.createRow(0);
            CellStyle cellStyle = wookbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            title.createCell(0).setCellValue("编号");
            title.getCell(0).setCellStyle(cellStyle);
            title.createCell(1).setCellValue("名称");
            title.createCell(2).setCellValue("备注");

            for (int i = 0; i < roleList.size(); i++) {
                Role role = roleList.get(i);
                int rowId = i + 1;
                Row row = sheet.createRow(rowId);
                row.createCell(0).setCellValue(role.getId());
                row.getCell(0).setCellStyle(cellStyle);
                row.createCell(1).setCellValue(role.getRoleName());
                row.createCell(2).setCellValue(role.getNote());
            }
        };
    }


}
