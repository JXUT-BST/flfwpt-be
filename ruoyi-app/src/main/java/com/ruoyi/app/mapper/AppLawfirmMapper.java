package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppLawfirm;

/**
 * 律所信息Mapper接口
 * 
 * @author weilai
 * @date 2024-12-28
 */
public interface AppLawfirmMapper 
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
     * 删除律所信息
     * 
     * @param lawfirmId 律所信息主键
     * @return 结果
     */
    public int deleteAppLawfirmByLawfirmId(Long lawfirmId);

    /**
     * 批量删除律所信息
     * 
     * @param lawfirmIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppLawfirmByLawfirmIds(Long[] lawfirmIds);
}
