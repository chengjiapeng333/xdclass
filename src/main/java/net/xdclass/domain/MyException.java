package net.xdclass.domain;

/**
 * Created by chengjiapeng on 2018/9/9.
 * 自定义异常类
 */
public class MyException extends RuntimeException{
    private String code;

    private String msg;

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
