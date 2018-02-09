package com.igl.gov.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserDto implements Serializable {

    private Integer id;

    private String username;

    @JsonFormat(pattern = "YYYY-mm-dd HH:MM:ss")
    private Date createTime;

    private String name;

    private String email;

    private String mobile;

    private Integer gender;

    private String roleIds;

    private String orgIds;

    private String roleNames;

    private String orgNames;
}
