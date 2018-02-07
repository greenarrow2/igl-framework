package com.igl.gov.common.config;

import com.igl.gov.common.api.DataResult;
import com.igl.gov.common.exception.IglException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = "com.igl.gov")
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    private Logger logger = Logger.getLogger(ExceptionControllerAdvice.class);
    @ExceptionHandler(IglException.class)
    @ResponseBody
    DataResult handleControllerException(HttpServletRequest request, Throwable ex) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode != null && statusCode.equals(404)){
            return new DataResult(false,"资源找不到!");
        }
        return new DataResult(false,ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    DataResult handleControllerSysException(HttpServletRequest request, Throwable ex) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode != null && statusCode.equals(404)){
            return new DataResult(false,"资源找不到!");
        }
        logger.error(ex.getLocalizedMessage(),ex);
        return new DataResult(false,"系统异常请联系管理员！");
    }
}
