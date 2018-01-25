package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataResult;
import com.igl.gov.system.dto.SysDictSimpleDto;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.entity.SysDictionary;
import com.igl.gov.system.service.SysDictionaryService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api/sysdict/")
public class SysDictionaryController {

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @RequestMapping(value = "dictlistbydictno")
    public List<SysDictSimpleDto> dictListByDictNo(Integer dictNo) throws UnsupportedEncodingException {
        return sysDictionaryService.querySysDictionaryByDictNo(dictNo);
    }

    @RequestMapping(value = "save")
    public DataResult save(SysDictionary dictionary) throws UnsupportedEncodingException {
        return new DataResult(true,sysDictionaryService.save(dictionary));
    }

    @RequestMapping(value = "query")
    public DataResult query(String id) throws UnsupportedEncodingException {
        System.out.println("---------" + SecurityUtils.getSubject().getPrincipal());
        System.out.println(SecurityUtils.getSubject().hasRole("admin"));
        return new DataResult(true,"你好" + id);
    }

}
