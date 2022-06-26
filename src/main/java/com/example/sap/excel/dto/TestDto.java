package com.example.sap.excel.dto;


import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@ToString
@Getter
@Setter
public class TestDto {

    private String excelStringData;
    private int  ZID;
    private String ZItemSeq;
    private String ZItemDes;
}
