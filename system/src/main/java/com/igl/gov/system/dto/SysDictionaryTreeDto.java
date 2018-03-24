package com.igl.gov.system.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class SysDictionaryTreeDto implements Serializable{

    private Integer moduleDictNo;

    private String moduleDictDesc;

    private List<SysDictionaryNoDto> dictNoList = new ArrayList<>();

}
