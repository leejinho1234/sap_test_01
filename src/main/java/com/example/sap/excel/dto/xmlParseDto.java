package com.example.sap.excel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@XmlRootElement(name = "m:properties")
public class xmlParseDto {
    @XmlAttribute(name = "d:ObjectID")
    private String ObjectID;
}
