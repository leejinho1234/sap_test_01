package com.example.sap.excel.dto;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@ToString
@Getter
@Setter
public class TestDto {

    private String excelStringData;
    private int  ZID;
    private String ZItemSeq;
    private String ZItemDes;
}
