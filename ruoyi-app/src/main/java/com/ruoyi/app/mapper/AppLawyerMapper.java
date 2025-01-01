package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppLawyer;

/**
 * 律师信息Mapper接口
 * 
 * @author weilai
 * @date 2024-12-31
 */
public interface AppLawyerMapper 
{
    /**
     * 查询律师信息
     * 
     * @param lawyerId 律师信息主键
     * @return 律师信息
     */
    public AppLawyer selectAppLawyerByLawyerId(Long lawyerId);

    /**
     * 查询律师信息列表
     * 
     * @param appLawyer 律师信息
     * @return 律师信息集合
     */
    public List<AppLawyer> selectAppLawyerList(AppLawyer appLawyer);

    /**
     * 新增律师信息
     * 
     * @param appLawyer 律师信息
     * @return 结果
     */
    public int insertAppLawyer(AppLawyer appLawyer);

    /**
     * 修改律师信息
     * 
     * @param appLawyer 律师信息
     * @return 结果
     */
    public int updateAppLawyer(AppLawyer appLawyer);

    /**
     * 删除律师信息
     * 
     * @param lawyerId 律师信息主键
     * @return 结果
     */
    public int deleteAppLawyerByLawyerId(Long lawyerId);

    /**
     * 批量删除律师信息
     * 
     * @param lawyerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppLawyerByLawyerIds(Long[] lawyerIds);
}
