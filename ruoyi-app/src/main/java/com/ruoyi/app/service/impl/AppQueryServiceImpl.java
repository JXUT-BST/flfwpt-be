package com.ruoyi.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppQueryMapper;
import com.ruoyi.app.domain.AppQuery;
import com.ruoyi.app.service.IAppQueryService;

/**
 * 客户提问Service业务层处理
 * 
 * @author weilai
 * @date 2025-01-02
 */
@Service
public class AppQueryServiceImpl implements IAppQueryService 
{
    @Autowired
    private AppQueryMapper appQueryMapper;

    /**
     * 查询客户提问
     * 
     * @param legalQaId 客户提问主键
     * @return 客户提问
     */
    @Override
    public AppQuery selectAppQueryByLegalQaId(Long legalQaId)
    {
        return appQueryMapper.selectAppQueryByLegalQaId(legalQaId);
    }

    /**
     * 查询客户提问列表
     * 
     * @param appQuery 客户提问
     * @return 客户提问
     */
    @Override
    public List<AppQuery> selectAppQueryList(AppQuery appQuery)
    {
        return appQueryMapper.selectAppQueryList(appQuery);
    }

    /**
     * 新增客户提问
     * 
     * @param appQuery 客户提问
     * @return 结果
     */
    @Override
    public int insertAppQuery(AppQuery appQuery)
    {
        appQuery.setCreateTime(DateUtils.getNowDate());
        return appQueryMapper.insertAppQuery(appQuery);
    }

    /**
     * 修改客户提问
     * 
     * @param appQuery 客户提问
     * @return 结果
     */
    @Override
    public int updateAppQuery(AppQuery appQuery)
    {
        appQuery.setUpdateTime(DateUtils.getNowDate());
        return appQueryMapper.updateAppQuery(appQuery);
    }

    /**
     * 批量删除客户提问
     * 
     * @param legalQaIds 需要删除的客户提问主键
     * @return 结果
     */
    @Override
    public int deleteAppQueryByLegalQaIds(Long[] legalQaIds)
    {
        return appQueryMapper.deleteAppQueryByLegalQaIds(legalQaIds);
    }

    /**
     * 删除客户提问信息
     * 
     * @param legalQaId 客户提问主键
     * @return 结果
     */
    @Override
    public int deleteAppQueryByLegalQaId(Long legalQaId)
    {
        return appQueryMapper.deleteAppQueryByLegalQaId(legalQaId);
    }
}
