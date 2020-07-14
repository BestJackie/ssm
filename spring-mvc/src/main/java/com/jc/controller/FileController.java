package com.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * FileName: FileController
 *
 * @author: haichaoyang3
 * @date: 2020/7/14 10:12
 * Description:
 * History:
 * since: 1.0.0
 */
@Controller
@RequestMapping("file")
public class FileController {

    @GetMapping("init")
    public String init() {
        return "upload";
    }

    /**
     * 通过servletApi上传文件
     *
     * @param request
     * @return
     */
    @PostMapping("upload")
    public ModelAndView upload(HttpServletRequest request) {
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = mhsr.getFile("file");
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        String fileName = multipartFile.getOriginalFilename();
        File dest = new File(fileName);
        try {
            multipartFile.transferTo(dest);
            mv.addObject("success", "true");
            mv.addObject("msg", "上传成功");
        } catch (IOException e) {
            mv.addObject("success", "false");
            mv.addObject("msg", "上传失败");
        }
        return mv;
    }

    /**
     * 使用multipartFile上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("uploadMultipartFile")
    public ModelAndView uploadMultipartFile(MultipartFile file) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        String fileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        File dest = new File(fileName);
        try {
            file.transferTo(dest);
            mv.addObject("success", "true");
            mv.addObject("msg", "上传成功");
        } catch (IOException e) {
            mv.addObject("success", "false");
            mv.addObject("msg", "上传失败");
        }
        return mv;
    }

    /**
     * 使用Part上传文件，Part是ServletAPI提供的类
     * @param file
     * @return
     */
    @PostMapping("uploadPart")
    public ModelAndView uploadPart(Part file) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        String fileName = file.getSubmittedFileName();
        File dest = new File(fileName);
        try {
            file.write("D:/mvc/upload/" + fileName);
            mv.addObject("success", "true");
            mv.addObject("msg", "上传成功");
        } catch (IOException e) {
            mv.addObject("success", "false");
            mv.addObject("msg", "上传失败");
        }
        return mv;
    }


}
