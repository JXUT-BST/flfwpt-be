package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 律所信息对象 app_lawfirm
 * 
 * @author weilai
 * @date 2024-12-28
 */
public class AppLawfirm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 律所ID */
    private Long lawfirmId;

    /** 律所名称 */
    @Excel(name = "律所名称")
    private String lawfirmName;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 简介 */
    @Excel(name = "简介")
    private String introduction;

    /** 擅长领域 */
    @Excel(name = "擅长领域")
    private String field;

    /** 营业时间 */
    @Excel(name = "营业时间")
    private String businessHours;

    /** 营业地址 */
    @Excel(name = "营业地址")
    private String address;

    public void setLawfirmId(Long lawfirmId) 
    {
        this.lawfirmId = lawfirmId;
    }

    public Long getLawfirmId() 
    {
        return lawfirmId;
    }
    public void setLawfirmName(String lawfirmName) 
    {
        this.lawfirmName = lawfirmName;
    }

    public String getLawfirmName() 
    {
        return lawfirmName;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setField(String field) 
    {
        this.field = field;
    }

    public String getField() 
    {
        return field;
    }
    public void setBusinessHours(String businessHours) 
    {
        this.businessHours = businessHours;
    }

    public String getBusinessHours() 
    {
        return businessHours;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lawfirmId", getLawfirmId())
            .append("lawfirmName", getLawfirmName())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("introduction", getIntroduction())
            .append("field", getField())
            .append("businessHours", getBusinessHours())
            .append("address", getAddress())
            .toString();
    }
}
