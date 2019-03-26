package com.molice.web.controller;

import com.molice.annotation.DataPack;
import com.molice.exception.ServiceException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 
 * @ClassName: 捕捉异常进行处理
 * @Description: 对特定的异常处理可以在这个类里面实现
 * @author: molice
 * @date: 2018年5月3日 上午10:13:01
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BindException.class)
    @DataPack
    public Object UnauthorizedExceptionHandler(BindException ex){
        System.out.println("=====================BindException异常信息捕获=======================");
        ObjectError result = null;
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> objectErrorList = bindingResult.getAllErrors();
        for (ObjectError error : objectErrorList) {
            result = error;
            break;
        }
        if (result != null) {
            throw new ServiceException(result.getDefaultMessage());
        }
        return 1;
    }

}
