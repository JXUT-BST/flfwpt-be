package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 律师信息对象 app_lawyer
 * 
 * @author weilai
 * @date 2024-12-31
 */
public class AppLawyer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 律所ID */
    private Long lawyerId;

    /** 删除标记（0代表存在，2代表删除） */
    private String delFlag;

    /** 简介 */
    @Excel(name = "简介")
    private String introduction;

    /** 标签 */
    @Excel(name = "标签")
    private String field;

    /** 营业时间 */
    @Excel(name = "营业时间")
    private String businessHours;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 律师名称 */
    @Excel(name = "律师名称")
    private String lawyerName;

    public void setLawyerId(Long lawyerId) 
    {
        this.lawyerId = lawyerId;
    }

    public Long getLawyerId() 
    {
        return lawyerId;
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
    public void setLawyerName(String lawyerName) 
    {
        this.lawyerName = lawyerName;
    }

    public String getLawyerName() 
    {
        return lawyerName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lawyerId", getLawyerId())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .append("introduction", getIntroduction())
            .append("field", getField())
            .append("businessHours", getBusinessHours())
            .append("address", getAddress())
            .append("lawyerName", getLawyerName())
            .toString();
    }
}
