package com.example.sap.excel.dto;

import java.util.List;
import java.util.Map;

public class ExcelDto {
    private int  ZID;
    private String ZItemSeq;
    private String ZItemDes;

    //private List<ExcelDto> ExcelDtoList;
    private List<Map<String, Object>> ExcelDtoList;

    public int getZID(){
        return ZID;
    }
    public void setZID(int ZID){
        this.ZID = ZID;
    }

    public String getZItemSeq(){
        return ZItemSeq;
    }
    public void setZItemSeq(String ZItemSeq){
        this.ZItemSeq = ZItemSeq;
    }

    public String getZItemDes(){
        return ZItemDes;
    }
    public void setZItemDes(String ZItemDes){
        this.ZItemDes = ZItemDes;
    }


    public void setExcelDtoList(List<Map<String, Object>> ExcelDtoList) {
        this.ExcelDtoList = ExcelDtoList;
    }

    public List<Map<String, Object>> getExcelDtoList(){
        return ExcelDtoList;
    }
}
