package com.ruoyi.app.service;

import java.util.List;
import com.ruoyi.app.domain.AppLawfirm;

/**
 * 律所信息Service接口
 * 
 * @author weilai
 * @date 2024-12-28
 */
public interface IAppLawfirmService 
{
    /**
     * 查询律所信息
     * 
     * @param lawfirmId 律所信息主键
     * @return 律所信息
     */
    public AppLawfirm selectAppLawfirmByLawfirmId(Long lawfirmId);

    /**
     * 查询律所信息列表
     * 
     * @param appLawfirm 律所信息
     * @return 律所信息集合
     */
    public List<AppLawfirm> selectAppLawfirmList(AppLawfirm appLawfirm);

    /**
     * 新增律所信息
     * 
     * @param appLawfirm 律所信息
     * @return 结果
     */
    public int insertAppLawfirm(AppLawfirm appLawfirm);

    /**
     * 修改律所信息
     * 
     * @param appLawfirm 律所信息
     * @return 结果
     */
    public int updateAppLawfirm(AppLawfirm appLawfirm);

    /**
     * 批量删除律所信息
     * 
     * @param lawfirmIds 需要删除的律所信息主键集合
     * @return 结果
     */
    public int deleteAppLawfirmByLawfirmIds(Long[] lawfirmIds);

    /**
     * 删除律所信息信息
     * 
     * @param lawfirmId 律所信息主键
     * @return 结果
     */
    public int deleteAppLawfirmByLawfirmId(Long lawfirmId);
}
