package com.igl.gov.system.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysDictionary  implements Serializable {

    private Integer id;

    private Integer dictCode;

    private String  dictName;

    private Integer dictNo;

    private String dictDesc;

    private String remarks;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer version;

}
