package com.example.sap.excel.service;

import com.example.sap.excel.dto.TestDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    public void ExcelSer(TestDto param){
        //DTO 테스트
        String stringParam = param.getExcelStringData();
        System.out.println("Service : " + stringParam);
        JSONArray jsonArray = new JSONArray(stringParam);
        Gson gson = new Gson();
        List<TestDto> testDto = gson.fromJson(stringParam, new TypeToken<List<TestDto>>(){}.getType());

        System.out.println(testDto);

        PostAPI(testDto);
    }

    public void PostAPI(List<TestDto> testDto) {
        HttpURLConnection conn = null;
        JSONObject responseJson = null;

        String Username = "_WEB";
        String Password = "dlwlsgh1595A";
        String idandpw = Username + ":" + Password;
        Base64EncodeService base64EncodeService = new Base64EncodeService();
        String Auth = "Basic " + base64EncodeService.Encode(idandpw);

         try {
             URL url = new URL("https://my353278.sapbydesign.com/sap/byd/odata/cust/v1/zwebtest/ZWebTestRootCollection");

         }
         catch (Exception e){

         }

    }



}
