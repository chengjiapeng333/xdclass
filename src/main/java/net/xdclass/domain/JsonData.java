package net.xdclass.domain;

import java.io.Serializable;

/**
 * Created by chengjiapeng on 2018/9/2.
 */
public class JsonData implements Serializable{

    //状态码, 0 表示成功, -1 表示失败
    private int code;

    private Object data;

    private String message;

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonData(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public JsonData(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static JsonData buildSuccess(Object obj) {
        return new JsonData(0, obj);
    }

    public static JsonData buildSuccess() {
        return new JsonData(0);
    }

    public static JsonData fail(String msg) {
        return new JsonData(-1, null, msg);
    }
}
