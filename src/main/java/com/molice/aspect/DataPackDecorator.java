package com.molice.aspect;

import com.molice.exception.ServiceException;
import com.molice.response.ExecuteResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 为接口规范,方便开发 
 * { "success": true, "exceptionMessage": null, "exceptionStack": null, "returnObject": { "id": 0, "content": "1231" } }
 * @author molice
 */
@Component
@Aspect
@Order(10)
public class DataPackDecorator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	@Around("@annotation(com.molice.annotation.DataPack) && within(com.molice.web.controller..*)")
	public Object decorate(ProceedingJoinPoint pjp) throws Throwable {

		// 定义返回结果封装类
		ExecuteResponse<Object> er = new ExecuteResponse<Object>();
		try {
			Object o = pjp.proceed();
			er.setSuccess(Boolean.TRUE);
			er.setReturnObject(o);
		} catch (Exception e) {
		    logger.error("API 失败!", e);
            logger.error("类: " + pjp.getSignature().getDeclaringTypeName());
            logger.error("方法: " + pjp.getSignature().getName());
            logger.error("参数: " + Arrays.toString(pjp.getArgs()));
			er.setSuccess(Boolean.FALSE);
			er.setExceptionMessage(e.getMessage());
			
			// 如果是运行时异常，则传送堆栈信息
			if (e instanceof RuntimeException && !(e instanceof ServiceException)) {
				er.setExceptionMessage("系统出错，请联系管理员！");
				er.setExceptionStack(e.getMessage());
			}
		}
		return er;
	}
}
