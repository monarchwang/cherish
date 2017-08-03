package com.monarchwang.website.utils.http;

/**
 * http异常
 * 
 */
public class HttpException extends Exception {

    /**  */
    private static final long serialVersionUID = 1L;

    protected int code;

    protected String msg;

    public HttpException() {}

    public HttpException(String msg) {
        this.msg = msg;
    }

    public HttpException(int code) {
        this.code = code;
    }

    public HttpException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HttpException(Exception e) {
        super(e);
    }

    public HttpException(String msg, Exception e) {
        super(msg, e);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
