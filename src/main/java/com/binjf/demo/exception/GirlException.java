package com.binjf.demo.exception;

import com.binjf.demo.enums.ResultEnum;

/**
 * 自定义异常类
 *
 * @author Sky
 * @create 2018-08-05 下午4:44
 **/
public class GirlException extends RuntimeException {

    private Integer code;

    /**
     * 构造方法，父类构造方法有一个message
     * @param resultEnum
     */
    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
