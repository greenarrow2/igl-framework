package com.igl.gov.system.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysDictionary  implements Serializable {
    @ApiModelProperty(value = "字典ID", required = true)
    private Integer id;

    private Integer dictCode;

    private String  dictName;

    private Integer dictNo;

    private String dictDesc;

    private Integer moduleDictNo;

    private String moduleDictDesc;

    private String remarks;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer version;

}
