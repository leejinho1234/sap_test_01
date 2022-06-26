package com.example.sap.excel.service;

import com.example.sap.excel.dto.TestDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    public void ExcelSer(TestDto param){
        String stringParam = param.getExcelStringData();
        System.out.println("Service : " + stringParam);
        JSONArray jsonArray = new JSONArray(stringParam);
        Gson gson = new Gson();
        List<TestDto> testDto = gson.fromJson(stringParam, new TypeToken<List<TestDto>>(){}.getType());

        System.out.println(testDto);
    }
}
