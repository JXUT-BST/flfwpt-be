package com.ruoyi.system.domain;


import java.io.Serializable;

public class WxLoginResponseBody implements Serializable {

    //    appid: appId,
//            *         secret: appSecret,
//            *         js_code: code,
//            *         grant_type: 'authorization_code'
//
//
    private static final long serialVersionUID = 1L;
    private String session_key;
    private String unionid;
    private String errmsg;
    private String openid;
    private String errcode;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    @Override
    public String toString() {
        return "WxLoginResponseBody{" +
                "session_key='" + session_key + '\'' +
                ", unionid='" + unionid + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", openid='" + openid + '\'' +
                ", errcode='" + errcode + '\'' +
                '}';
    }
}