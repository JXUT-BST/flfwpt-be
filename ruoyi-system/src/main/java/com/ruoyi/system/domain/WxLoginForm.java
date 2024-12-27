package com.ruoyi.system.domain;

import java.io.Serializable;

/**
 * 微信登录参数
 */
public class WxLoginForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
