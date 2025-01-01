package com.ruoyi.app.service;

import java.util.List;
import com.ruoyi.app.domain.AppLegalQa;

/**
 * 法律问答信息Service接口
 * 
 * @author weilai
 * @date 2024-12-31
 */
public interface IAppLegalQaService 
{
    /**
     * 查询法律问答信息
     * 
     * @param legalQaId 法律问答信息主键
     * @return 法律问答信息
     */
    public AppLegalQa selectAppLegalQaByLegalQaId(Long legalQaId);

    /**
     * 查询法律问答信息列表
     * 
     * @param appLegalQa 法律问答信息
     * @return 法律问答信息集合
     */
    public List<AppLegalQa> selectAppLegalQaList(AppLegalQa appLegalQa);

    /**
     * 新增法律问答信息
     * 
     * @param appLegalQa 法律问答信息
     * @return 结果
     */
    public int insertAppLegalQa(AppLegalQa appLegalQa);

    /**
     * 修改法律问答信息
     * 
     * @param appLegalQa 法律问答信息
     * @return 结果
     */
    public int updateAppLegalQa(AppLegalQa appLegalQa);

    /**
     * 批量删除法律问答信息
     * 
     * @param legalQaIds 需要删除的法律问答信息主键集合
     * @return 结果
     */
    public int deleteAppLegalQaByLegalQaIds(Long[] legalQaIds);

    /**
     * 删除法律问答信息信息
     * 
     * @param legalQaId 法律问答信息主键
     * @return 结果
     */
    public int deleteAppLegalQaByLegalQaId(Long legalQaId);
}
