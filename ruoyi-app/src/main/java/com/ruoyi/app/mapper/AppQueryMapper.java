package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppQuery;

/**
 * 客户提问Mapper接口
 * 
 * @author weilai
 * @date 2025-01-02
 */
public interface AppQueryMapper 
{
    /**
     * 查询客户提问
     * 
     * @param legalQaId 客户提问主键
     * @return 客户提问
     */
    public AppQuery selectAppQueryByLegalQaId(Long legalQaId);

    /**
     * 查询客户提问列表
     * 
     * @param appQuery 客户提问
     * @return 客户提问集合
     */
    public List<AppQuery> selectAppQueryList(AppQuery appQuery);

    /**
     * 新增客户提问
     * 
     * @param appQuery 客户提问
     * @return 结果
     */
    public int insertAppQuery(AppQuery appQuery);

    /**
     * 修改客户提问
     * 
     * @param appQuery 客户提问
     * @return 结果
     */
    public int updateAppQuery(AppQuery appQuery);

    /**
     * 删除客户提问
     * 
     * @param legalQaId 客户提问主键
     * @return 结果
     */
    public int deleteAppQueryByLegalQaId(Long legalQaId);

    /**
     * 批量删除客户提问
     * 
     * @param legalQaIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppQueryByLegalQaIds(Long[] legalQaIds);
}
