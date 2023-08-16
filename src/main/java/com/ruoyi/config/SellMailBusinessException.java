package com.ruoyi.config;

import com.ruoyi.enums.SellMailBusinessExceptionEnum;

import java.io.Serializable;

/**
 * @author: 石恒
 * @DateTime: 2019-09-04 17:34
 * @qq: 374696376
 * @Description:
 */

public class SellMailBusinessException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 异常
     */
    private SellMailBusinessExceptionEnum exception;


    public SellMailBusinessException(String message) {
        super(message);
    }

    public SellMailBusinessException(SellMailBusinessExceptionEnum exception, String msg) {
        super(msg);
        this.exception = exception;
    }


    public SellMailBusinessExceptionEnum getException() {
        return exception;
    }

    public void setException(SellMailBusinessExceptionEnum exception) {
        this.exception = exception;
    }


}
