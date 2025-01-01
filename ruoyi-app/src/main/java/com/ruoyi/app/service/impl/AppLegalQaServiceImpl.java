package com.ruoyi.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppLegalQaMapper;
import com.ruoyi.app.domain.AppLegalQa;
import com.ruoyi.app.service.IAppLegalQaService;

/**
 * 法律问答信息Service业务层处理
 * 
 * @author weilai
 * @date 2024-12-31
 */
@Service
public class AppLegalQaServiceImpl implements IAppLegalQaService 
{
    @Autowired
    private AppLegalQaMapper appLegalQaMapper;

    /**
     * 查询法律问答信息
     * 
     * @param legalQaId 法律问答信息主键
     * @return 法律问答信息
     */
    @Override
    public AppLegalQa selectAppLegalQaByLegalQaId(Long legalQaId)
    {
        return appLegalQaMapper.selectAppLegalQaByLegalQaId(legalQaId);
    }

    /**
     * 查询法律问答信息列表
     * 
     * @param appLegalQa 法律问答信息
     * @return 法律问答信息
     */
    @Override
    public List<AppLegalQa> selectAppLegalQaList(AppLegalQa appLegalQa)
    {
        return appLegalQaMapper.selectAppLegalQaList(appLegalQa);
    }

    /**
     * 新增法律问答信息
     * 
     * @param appLegalQa 法律问答信息
     * @return 结果
     */
    @Override
    public int insertAppLegalQa(AppLegalQa appLegalQa)
    {
        appLegalQa.setCreateTime(DateUtils.getNowDate());
        return appLegalQaMapper.insertAppLegalQa(appLegalQa);
    }

    /**
     * 修改法律问答信息
     * 
     * @param appLegalQa 法律问答信息
     * @return 结果
     */
    @Override
    public int updateAppLegalQa(AppLegalQa appLegalQa)
    {
        appLegalQa.setUpdateTime(DateUtils.getNowDate());
        return appLegalQaMapper.updateAppLegalQa(appLegalQa);
    }

    /**
     * 批量删除法律问答信息
     * 
     * @param legalQaIds 需要删除的法律问答信息主键
     * @return 结果
     */
    @Override
    public int deleteAppLegalQaByLegalQaIds(Long[] legalQaIds)
    {
        return appLegalQaMapper.deleteAppLegalQaByLegalQaIds(legalQaIds);
    }

    /**
     * 删除法律问答信息信息
     * 
     * @param legalQaId 法律问答信息主键
     * @return 结果
     */
    @Override
    public int deleteAppLegalQaByLegalQaId(Long legalQaId)
    {
        return appLegalQaMapper.deleteAppLegalQaByLegalQaId(legalQaId);
    }
}
