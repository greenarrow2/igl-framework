package com.igl.gov.system.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据字典dto类
 */
@Data
public class SysDictionaryDto implements Serializable {

    private Integer id;

    private Integer dictCode;

    private String  dictName;

    private Integer dictNo;

    private Integer moduleDictNo;

    private String moduleDictDesc;

    private String dictDesc;

    private String remarks;
}
