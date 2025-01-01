package com.ruoyi.app.controller;

import com.ruoyi.app.domain.AppQuery;
import com.ruoyi.app.service.IAppQueryService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 客户提问Controller
 *
 * @author weilai
 * @date 2025-01-02
 */
@RestController
@RequestMapping("/app/query")
public class AppQueryController extends BaseController {
    @Autowired
    private IAppQueryService appQueryService;

    /**
     * 查询客户提问列表
     */
    @PreAuthorize("@ss.hasPermi('app:query:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppQuery appQuery) {
        startPage();
        List<AppQuery> list = appQueryService.selectAppQueryList(appQuery);
        return getDataTable(list);
    }

    /**
     * 导出客户提问列表
     */
    @PreAuthorize("@ss.hasPermi('app:query:export')")
    @Log(title = "客户提问", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppQuery appQuery) {
        List<AppQuery> list = appQueryService.selectAppQueryList(appQuery);
        ExcelUtil<AppQuery> util = new ExcelUtil<AppQuery>(AppQuery.class);
        util.exportExcel(response, list, "客户提问数据");
    }

    /**
     * 获取客户提问详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:query:query')")
    @GetMapping(value = "/{legalQaId}")
    public AjaxResult getInfo(@PathVariable("legalQaId") Long legalQaId) {
        return success(appQueryService.selectAppQueryByLegalQaId(legalQaId));
    }

    /**
     * 新增客户提问
     */
    @PreAuthorize("@ss.hasPermi('app:query:add')")
    @Log(title = "客户提问", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppQuery appQuery) {
        appQuery.setCreateBy(getUsername());
        return toAjax(appQueryService.insertAppQuery(appQuery));
    }

    /**
     * 修改客户提问
     */
    @PreAuthorize("@ss.hasPermi('app:query:edit')")
    @Log(title = "客户提问", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppQuery appQuery) {
        appQuery.setUpdateBy(getUsername());
        return toAjax(appQueryService.updateAppQuery(appQuery));
    }

    /**
     * 删除客户提问
     */
    @PreAuthorize("@ss.hasPermi('app:query:remove')")
    @Log(title = "客户提问", businessType = BusinessType.DELETE)
    @DeleteMapping("/{legalQaIds}")
    public AjaxResult remove(@PathVariable Long[] legalQaIds) {
        return toAjax(appQueryService.deleteAppQueryByLegalQaIds(legalQaIds));
    }
}
