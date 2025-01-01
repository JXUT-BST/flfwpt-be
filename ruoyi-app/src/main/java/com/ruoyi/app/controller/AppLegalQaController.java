package com.ruoyi.app.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.app.domain.AppLegalQa;
import com.ruoyi.app.service.IAppLegalQaService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 法律问答信息Controller
 *
 * @author weilai
 * @date 2024-12-31
 */
@RestController
@RequestMapping("/app/qa")
public class AppLegalQaController extends BaseController {
    @Autowired
    private IAppLegalQaService appLegalQaService;

/**
 * 查询法律问答信息列表
 */
@PreAuthorize("@ss.hasPermi('app:qa:list')")
@GetMapping("/list")
    public TableDataInfo list(AppLegalQa appLegalQa) {
        startPage();
        List<AppLegalQa> list = appLegalQaService.selectAppLegalQaList(appLegalQa);
        return getDataTable(list);
    }

    /**
     * 导出法律问答信息列表
     */
    @PreAuthorize("@ss.hasPermi('app:qa:export')")
    @Log(title = "法律问答信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppLegalQa appLegalQa) {
        List<AppLegalQa> list = appLegalQaService.selectAppLegalQaList(appLegalQa);
        ExcelUtil<AppLegalQa> util = new ExcelUtil<AppLegalQa>(AppLegalQa. class);
        util.exportExcel(response, list, "法律问答信息数据");
    }

    /**
     * 获取法律问答信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:qa:query')")
    @GetMapping(value = "/{legalQaId}")
    public AjaxResult getInfo(@PathVariable("legalQaId") Long legalQaId) {
        return success(appLegalQaService.selectAppLegalQaByLegalQaId(legalQaId));
    }

    /**
     * 新增法律问答信息
     */
    @PreAuthorize("@ss.hasPermi('app:qa:add')")
    @Log(title = "法律问答信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppLegalQa appLegalQa) {
        appLegalQa.setCreateBy(getUsername());
        return toAjax(appLegalQaService.insertAppLegalQa(appLegalQa));
    }

    /**
     * 修改法律问答信息
     */
    @PreAuthorize("@ss.hasPermi('app:qa:edit')")
    @Log(title = "法律问答信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppLegalQa appLegalQa) {
        appLegalQa.setUpdateBy(getUsername());
        return toAjax(appLegalQaService.updateAppLegalQa(appLegalQa));
    }

    /**
     * 删除法律问答信息
     */
    @PreAuthorize("@ss.hasPermi('app:qa:remove')")
    @Log(title = "法律问答信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{legalQaIds}")
    public AjaxResult remove(@PathVariable Long[] legalQaIds) {
        return toAjax(appLegalQaService.deleteAppLegalQaByLegalQaIds(legalQaIds));
    }
}
