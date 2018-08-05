package com.binjf.demo.handle;

import com.binjf.demo.controller.GirlController;
import com.binjf.demo.entity.Result;
import com.binjf.demo.exception.GirlException;
import com.binjf.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理增强类，用于处理当异常时，返回的数据结构为Result类
 *
 * @author Sky
 * @create 2018-08-05 下午4:19
 **/
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Result handle(Exception e){
//        return ResultUtil.error(100, e.getMessage());
//    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        //1 判断是否是自定义的异常GirlException
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }
        logger.error("【系统异常】{}", e);
        return ResultUtil.error(-1, "未知异常");
    }

}
