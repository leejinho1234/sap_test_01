package com.example.sap.excel.controller;


import com.example.sap.excel.dto.ExcelDto;
import com.example.sap.excel.dto.TestDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class controller implements WebMvcConfigurer {

    @RequestMapping("/home")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("excel/test");

        return mv;
    }
    @PostMapping("/home/test")
    public String homeTest(TestDto param) throws IOException {

        //String stringParam = param.getExcelStringData();
        List<TestDto> list = new ArrayList<>();
        String stringParam = param.getExcelStringData();

        JSONArray jsonArray = new JSONArray(stringParam);



        //TestDto testDto = new TestDto();
        List<TestDto> testDto = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Gson gson = new Gson();
            TestDto testDto_a = gson.fromJson(jsonObject.toString(), TestDto.class);

            testDto.add(testDto_a);
        }
        System.out.println(testDto);






        //}
        //System.out.println("TestDto : " + TestDto.toString());

        return "";
    }


}
