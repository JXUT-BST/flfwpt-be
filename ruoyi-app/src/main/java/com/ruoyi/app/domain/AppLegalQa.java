package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 法律问答信息对象 app_legal_qa
 * 
 * @author weilai
 * @date 2024-12-31
 */
public class AppLegalQa extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 律所ID */
    private Long legalQaId;

    /** 删除标记（0代表存在，2代表删除） */
    private String delFlag;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

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
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
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
            .append("content", getContent())
            .append("title", getTitle())
            .toString();
    }
}
