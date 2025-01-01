package com.ruoyi.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppLawyerMapper;
import com.ruoyi.app.domain.AppLawyer;
import com.ruoyi.app.service.IAppLawyerService;

/**
 * 律师信息Service业务层处理
 * 
 * @author weilai
 * @date 2024-12-31
 */
@Service
public class AppLawyerServiceImpl implements IAppLawyerService 
{
    @Autowired
    private AppLawyerMapper appLawyerMapper;

    /**
     * 查询律师信息
     * 
     * @param lawyerId 律师信息主键
     * @return 律师信息
     */
    @Override
    public AppLawyer selectAppLawyerByLawyerId(Long lawyerId)
    {
        return appLawyerMapper.selectAppLawyerByLawyerId(lawyerId);
    }

    /**
     * 查询律师信息列表
     * 
     * @param appLawyer 律师信息
     * @return 律师信息
     */
    @Override
    public List<AppLawyer> selectAppLawyerList(AppLawyer appLawyer)
    {
        return appLawyerMapper.selectAppLawyerList(appLawyer);
    }

    /**
     * 新增律师信息
     * 
     * @param appLawyer 律师信息
     * @return 结果
     */
    @Override
    public int insertAppLawyer(AppLawyer appLawyer)
    {
        appLawyer.setCreateTime(DateUtils.getNowDate());
        return appLawyerMapper.insertAppLawyer(appLawyer);
    }

    /**
     * 修改律师信息
     * 
     * @param appLawyer 律师信息
     * @return 结果
     */
    @Override
    public int updateAppLawyer(AppLawyer appLawyer)
    {
        appLawyer.setUpdateTime(DateUtils.getNowDate());
        return appLawyerMapper.updateAppLawyer(appLawyer);
    }

    /**
     * 批量删除律师信息
     * 
     * @param lawyerIds 需要删除的律师信息主键
     * @return 结果
     */
    @Override
    public int deleteAppLawyerByLawyerIds(Long[] lawyerIds)
    {
        return appLawyerMapper.deleteAppLawyerByLawyerIds(lawyerIds);
    }

    /**
     * 删除律师信息信息
     * 
     * @param lawyerId 律师信息主键
     * @return 结果
     */
    @Override
    public int deleteAppLawyerByLawyerId(Long lawyerId)
    {
        return appLawyerMapper.deleteAppLawyerByLawyerId(lawyerId);
    }
}
