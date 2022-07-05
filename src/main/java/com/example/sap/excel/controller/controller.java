package com.example.sap.excel.controller;


import com.example.sap.excel.dto.TestDto;
import com.example.sap.excel.service.ExcelService;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;


@Controller
public class controller implements WebMvcConfigurer {

    @RequestMapping("/home")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("excel/test");

        return mv;
    }
    @PostMapping("/home/test")
    public String homeTest(TestDto param) throws IOException, ParseException {

        ExcelService excelService = new ExcelService();
        excelService.ExcelSer(param);

        return "excel/test";
    }


}
