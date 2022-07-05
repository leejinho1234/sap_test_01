package com.example.sap.excel.service;

import com.example.sap.excel.dto.TestDto;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    public void ExcelSer(TestDto param) throws ParseException {
        //DTO 테스트
        String stringParam = param.getExcelStringData();
        System.out.println("Service : " + stringParam);
        JSONArray jsonArray = new JSONArray(stringParam);
        Gson gson = new Gson();
        List<TestDto> testDto = gson.fromJson(stringParam, new TypeToken<List<TestDto>>(){}.getType());
        //DTO 호출(toString)
        System.out.println(testDto);

        //PostAPI 호출
        PostAPI(testDto);
    }

    public void PostAPI(List<TestDto> testDto) throws ParseException {

        //Base64Encode Service 를 통한 Auth 생성
        String Username = "_WEB";
        String Password = "dlwlsgh1595A";
        String idandpw = Username + ":" + Password;
        Base64EncodeService base64EncodeService = new Base64EncodeService();
        String Auth = "Basic " + base64EncodeService.Encode(idandpw);

        //Header 값 추가
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization", Auth);
        httpHeaders.add("Content-Type", "application/json");

        //System.out.println("Auth" + Auth);

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectItem = new JSONObject();
        
        //REST API 전송
        for(int i=0; i<testDto.size(); i++){
            //===========================================================================================================
            //Root 생성 및 Object ID 파싱
            String url = "https://my353278.sapbydesign.com/sap/byd/odata/cust/v1/zwebtest/ZWebTestRootCollection";
            jsonObject.put("ZID", testDto.get(i).getZID());
            HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
            ResponseEntity<String> res = new RestTemplate().postForEntity(url, entity, String.class);

            System.out.println("Root : " + res.getBody());
            System.out.println("Root : " + res.getStatusCodeValue());

            JSONObject obj = new JSONObject(res.getBody());
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(obj);
            String ObjectID = obj.getJSONObject("d").getJSONObject("results").get("ObjectID").toString();
            //===========================================================================================================

            //===========================================================================================================
            //Item 생성
            url = "https://my353278.sapbydesign.com/sap/byd/odata/cust/v1/zwebtest/ZWebTestItemCollection";

            jsonObjectItem.put("ParentObjectID", ObjectID);
            jsonObjectItem.put("ZItemSeq", testDto.get(i).getZItemSeq());
            jsonObjectItem.put("ZItemDes", testDto.get(i).getZItemDes());

            HttpEntity<String> entityItem = new HttpEntity<String>(jsonObjectItem.toString(), httpHeaders);
            ResponseEntity<String> resItem = new RestTemplate().postForEntity(url, entityItem, String.class);

            System.out.println("Item : " + resItem.getBody());
            System.out.println("Item : " + resItem.getStatusCodeValue());
            //===========================================================================================================
        }
    }
}
