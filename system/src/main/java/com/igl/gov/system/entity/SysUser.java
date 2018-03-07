package com.igl.gov.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUser implements Serializable {

    private Integer id;

    private String  username;

    private String  name;

    private String  mobile;

    private String password;

    private String email;

    private Integer createBy;

    private Integer updateBy;

}
