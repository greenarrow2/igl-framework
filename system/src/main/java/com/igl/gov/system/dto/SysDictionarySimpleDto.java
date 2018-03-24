package com.igl.gov.system.dto;

import java.io.Serializable;

public class SysDictionarySimpleDto implements Serializable {

    private Integer dictCode;

    private String  dictName;

    public Integer getDictCode() {
        return dictCode;
    }

    public void setDictCode(Integer dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }
}
