package com.example.sap.excel.service;

import com.example.sap.excel.dto.TestDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
/*
public class RestAPIService {
    //HttpURLConnection conn = null;
    JSONObject responseJson = null;

    public void PostAPI(List<TestDto> testDto){
        try {
            URL url = new URL("https://my353278.sapbydesign.com/sap/byd/odata/cust/v1/zwebtest/ZWebTestRootCollection");
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Basic X1dFQjpkbHdsc2doMTU5NUE=");
            conn.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

            for(int i=0; i<=testDto.size(); i++){
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("ZID", testDto.get(i).getZID());
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonOutput = gson.toJson(jsonObject);

                bw.write(jsonObject.toString());
                bw.flush();
                bw.close();

                int responseCode = conn.getResponseCode();
                if(responseCode == 201){
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer();
                    String line = "";
                    while((line = br.readLine()) != null){
                        sb.append(line);
                    }
                    responseJson = new JSONObject(sb.toString());
                }
            }
        }
        catch (Exception e){

        }
    }
}
*/
