package com.igl.gov.system.controller;

import com.igl.gov.system.dto.SysDictSimpleDto;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.entity.SysDictionary;
import com.igl.gov.system.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/sysdict/")
public class SysDictionaryController {

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @RequestMapping(value = "dictlistbydictno")
    public List<SysDictSimpleDto> dictListByDictNo(Integer dictNo) throws UnsupportedEncodingException {
        return sysDictionaryService.querySysDictionaryByDictNo(dictNo);
    }

    @RequestMapping(value = "save")
    public SysDictionary save(SysDictionary dictionary) throws UnsupportedEncodingException {
        sysDictionaryService.save(dictionary);
        return dictionary;
    }
}
