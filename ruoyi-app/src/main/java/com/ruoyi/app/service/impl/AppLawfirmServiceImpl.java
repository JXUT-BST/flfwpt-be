package com.ruoyi.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppLawfirmMapper;
import com.ruoyi.app.domain.AppLawfirm;
import com.ruoyi.app.service.IAppLawfirmService;

/**
 * 律所信息Service业务层处理
 * 
 * @author weilai
 * @date 2024-12-28
 */
@Service
public class AppLawfirmServiceImpl implements IAppLawfirmService 
{
    @Autowired
    private AppLawfirmMapper appLawfirmMapper;

    /**
     * 查询律所信息
     * 
     * @param lawfirmId 律所信息主键
     * @return 律所信息
     */
    @Override
    public AppLawfirm selectAppLawfirmByLawfirmId(Long lawfirmId)
    {
        return appLawfirmMapper.selectAppLawfirmByLawfirmId(lawfirmId);
    }

    /**
     * 查询律所信息列表
     * 
     * @param appLawfirm 律所信息
     * @return 律所信息
     */
    @Override
    public List<AppLawfirm> selectAppLawfirmList(AppLawfirm appLawfirm)
    {
        return appLawfirmMapper.selectAppLawfirmList(appLawfirm);
    }

    /**
     * 新增律所信息
     * 
     * @param appLawfirm 律所信息
     * @return 结果
     */
    @Override
    public int insertAppLawfirm(AppLawfirm appLawfirm)
    {
        appLawfirm.setCreateTime(DateUtils.getNowDate());
        return appLawfirmMapper.insertAppLawfirm(appLawfirm);
    }

    /**
     * 修改律所信息
     * 
     * @param appLawfirm 律所信息
     * @return 结果
     */
    @Override
    public int updateAppLawfirm(AppLawfirm appLawfirm)
    {
        appLawfirm.setUpdateTime(DateUtils.getNowDate());
        return appLawfirmMapper.updateAppLawfirm(appLawfirm);
    }

    /**
     * 批量删除律所信息
     * 
     * @param lawfirmIds 需要删除的律所信息主键
     * @return 结果
     */
    @Override
    public int deleteAppLawfirmByLawfirmIds(Long[] lawfirmIds)
    {
        return appLawfirmMapper.deleteAppLawfirmByLawfirmIds(lawfirmIds);
    }

    /**
     * 删除律所信息信息
     * 
     * @param lawfirmId 律所信息主键
     * @return 结果
     */
    @Override
    public int deleteAppLawfirmByLawfirmId(Long lawfirmId)
    {
        return appLawfirmMapper.deleteAppLawfirmByLawfirmId(lawfirmId);
    }
}
