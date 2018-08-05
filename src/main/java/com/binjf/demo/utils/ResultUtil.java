package com.binjf.demo.utils;

import com.binjf.demo.entity.Result;

/**
 * 返回结构工具类
 *
 * @author Sky
 * @create 2018-08-05 下午3:43
 **/
public class ResultUtil {

    /**
     * 成功返回时的数据结构-有参
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 成功返回时的数据结构-无参
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 失败时返回的数据结构
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
