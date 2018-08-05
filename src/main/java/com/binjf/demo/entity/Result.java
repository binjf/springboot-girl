package com.binjf.demo.entity;

/**
 * 返回数据格式类，使用泛型支持
 *
 * @author Sky
 * @create 2018-08-05 下午3:34
 **/
public class Result<T> {
    /** 错误代码 */
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 具体的返回数据 */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
