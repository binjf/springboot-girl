package com.binjf.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * HTTP请求AOP
 *
 * @author Sky
 * @create 2018-08-05 下午2:51
 **/
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 在findGirlByAge方法执行前执行该方法
     */
    /*@Before("execution(public * com.binjf.demo.controller.GirlController.findGirlByAge(..))")
    public void doBeforeLog(){
        logger.info("HttpAspect before log ... ");
    }*/

    /**
     * 在findGirlByAge方法执行后执行该方法
     */
    /*@After("execution(public * com.binjf.demo.controller.GirlController.findGirlByAge(..))")
    public void doAfterLog(){
        logger.info("HttpAspect after log ... ");
    }*/

    /**
     * 上面的代码有重复部分，定义一个Poincut抽取重复代码
     */
    @Pointcut("execution(public * com.binjf.demo.controller.GirlController.findGirlByAge(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("HttpAspect before log ... ");

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //1 url
        logger.info("url={}", request.getRequestURL());
        //2 method
        logger.info("method={}", request.getMethod());
        //3 ip
        logger.info("id={}", request.getRemoteAddr());
        //4 类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //5 参数
        logger.info("args={}", joinPoint.getArgs());

    }
    @After("log()")
    public void doAfter(){
        logger.info("HttpAspect after log ... ");
    }

    /**
     * findGirlByAge方法返回时，获取放回值
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("afterReturning response={}", object.toString());
    }

}
