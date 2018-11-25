package com.hanggle.frames.exception;

import com.hanggle.frames.base.BaseResult;
import com.hanggle.frames.util.Response;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 全局异常 500 <br/>
 * @author : z.hang <br/>
 * Date: 2018-01-16 <br/>
 * Time: 0:03 <br/>
 */
@Slf4j
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResult defaultErrorHandler(HttpServletRequest req, Exception e)  {

        //业务异常
        if(e instanceof ServiceException){
            return Response.requestError(e);
        }

        if(e instanceof HttpRequestMethodNotSupportedException){
            return Response.requestError(e);
        }
        log.info("GlobalDefaultExceptionHandler[]defaultErrorHandler:{}", Throwables.getStackTraceAsString(e));
        return Response.unknowError(e);
    }
}