package com.ruoyi.app.controller;

import com.ruoyi.app.domain.AppLawfirm;
import com.ruoyi.app.service.IAppLawfirmService;
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
 * 律所信息Controller
 *
 * @author weilai
 * @date 2024-12-28
 */
@RestController
@RequestMapping("/app/lawfirm")
public class AppLawfirmController extends BaseController {
    @Autowired
    private IAppLawfirmService appLawfirmService;

    /**
     * 查询律所信息列表
     */
    @PreAuthorize("@ss.hasPermi('app:lawfirm:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppLawfirm appLawfirm) {
        startPage();
        List<AppLawfirm> list = appLawfirmService.selectAppLawfirmList(appLawfirm);
        return getDataTable(list);
    }

    /**
     * 导出律所信息列表
     */
    @PreAuthorize("@ss.hasPermi('app:lawfirm:export')")
    @Log(title = "律所信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppLawfirm appLawfirm) {
        List<AppLawfirm> list = appLawfirmService.selectAppLawfirmList(appLawfirm);
        ExcelUtil<AppLawfirm> util = new ExcelUtil<AppLawfirm>(AppLawfirm.class);
        util.exportExcel(response, list, "律所信息数据");
    }

    /**
     * 获取律所信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:lawfirm:query')")
    @GetMapping(value = "/{lawfirmId}")
    public AjaxResult getInfo(@PathVariable("lawfirmId") Long lawfirmId) {
        return success(appLawfirmService.selectAppLawfirmByLawfirmId(lawfirmId));
    }

    /**
     * 新增律所信息
     */
    @PreAuthorize("@ss.hasPermi('app:lawfirm:add')")
    @Log(title = "律所信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppLawfirm appLawfirm) {
        appLawfirm.setCreateBy(getUsername());
        return toAjax(appLawfirmService.insertAppLawfirm(appLawfirm));
    }

    /**
     * 修改律所信息
     */
    @PreAuthorize("@ss.hasPermi('app:lawfirm:edit')")
    @Log(title = "律所信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppLawfirm appLawfirm) {
        appLawfirm.setUpdateBy(getUsername());
        return toAjax(appLawfirmService.updateAppLawfirm(appLawfirm));
    }

    /**
     * 删除律所信息
     */
    @PreAuthorize("@ss.hasPermi('app:lawfirm:remove')")
    @Log(title = "律所信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{lawfirmIds}")
    public AjaxResult remove(@PathVariable Long[] lawfirmIds) {
        return toAjax(appLawfirmService.deleteAppLawfirmByLawfirmIds(lawfirmIds));
    }
}
