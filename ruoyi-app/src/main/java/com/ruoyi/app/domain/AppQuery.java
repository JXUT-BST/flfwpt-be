package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户提问对象 app_query
 * 
 * @author weilai
 * @date 2025-01-02
 */
public class AppQuery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 律所ID */
    private Long legalQaId;

    /** 删除标记（0代表存在，2代表删除） */
    private String delFlag;

    /** 微信ID */
    @Excel(name = "微信ID")
    private String wxOpenId;

    /** 问题类型 */
    @Excel(name = "问题类型")
    private String type;

    /** 详细信息 */
    @Excel(name = "详细信息")
    private String content;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 案件城市 */
    @Excel(name = "案件城市")
    private String city;

    public void setLegalQaId(Long legalQaId) 
    {
        this.legalQaId = legalQaId;
    }

    public Long getLegalQaId() 
    {
        return legalQaId;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setWxOpenId(String wxOpenId) 
    {
        this.wxOpenId = wxOpenId;
    }

    public String getWxOpenId() 
    {
        return wxOpenId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("legalQaId", getLegalQaId())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .append("wxOpenId", getWxOpenId())
            .append("type", getType())
            .append("content", getContent())
            .append("phoneNumber", getPhoneNumber())
            .append("city", getCity())
            .toString();
    }
}
