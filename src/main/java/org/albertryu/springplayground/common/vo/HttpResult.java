package org.albertryu.springplayground.common.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * RESTFUL return type
 * @param <T>
 */
@Data
public class HttpResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "ok";
    public static final int FAILED_CODE = 1;
    public static final String FAILED_MSG = "failed";

    public static final int BAD_REQUEST = 400;
    public static final int ENCRYPT_ERR = 500;
    public static final int DECRYPT_ERR = 501;
    public static final int DECRYPT__METHOD_ERR = 502;

    private String msg = SUCCESS_MSG;
    private int code = SUCCESS_CODE;
    private T data;

    public HttpResult() {
        super();
    }

    public HttpResult(T data, String msg, int code) {
        super();
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public HttpResult(String msg, int code) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public HttpResult(T data) {
        super();
        this.data = data;
    }
}

