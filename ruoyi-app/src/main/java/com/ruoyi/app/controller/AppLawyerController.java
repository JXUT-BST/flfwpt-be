package com.ruoyi.app.controller;

import com.ruoyi.app.domain.AppLawyer;
import com.ruoyi.app.service.IAppLawyerService;
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
 * 律师信息Controller
 *
 * @author weilai
 * @date 2024-12-31
 */
@RestController
@RequestMapping("/app/lawyer")
public class AppLawyerController extends BaseController {
    @Autowired
    private IAppLawyerService appLawyerService;

    /**
     * 查询律师信息列表
     */
    @PreAuthorize("@ss.hasPermi('app:lawyer:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppLawyer appLawyer) {
        startPage();
        List<AppLawyer> list = appLawyerService.selectAppLawyerList(appLawyer);
        return getDataTable(list);
    }

    /**
     * 导出律师信息列表
     */
    @PreAuthorize("@ss.hasPermi('app:lawyer:export')")
    @Log(title = "律师信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppLawyer appLawyer) {
        List<AppLawyer> list = appLawyerService.selectAppLawyerList(appLawyer);
        ExcelUtil<AppLawyer> util = new ExcelUtil<AppLawyer>(AppLawyer.class);
        util.exportExcel(response, list, "律师信息数据");
    }

    /**
     * 获取律师信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:lawyer:query')")
    @GetMapping(value = "/{lawyerId}")
    public AjaxResult getInfo(@PathVariable("lawyerId") Long lawyerId) {
        return success(appLawyerService.selectAppLawyerByLawyerId(lawyerId));
    }

    /**
     * 新增律师信息
     */
    @PreAuthorize("@ss.hasPermi('app:lawyer:add')")
    @Log(title = "律师信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppLawyer appLawyer) {
        appLawyer.setCreateBy(getUsername());
        return toAjax(appLawyerService.insertAppLawyer(appLawyer));
    }

    /**
     * 修改律师信息
     */
    @PreAuthorize("@ss.hasPermi('app:lawyer:edit')")
    @Log(title = "律师信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppLawyer appLawyer) {
        appLawyer.setUpdateBy(getUsername());
        return toAjax(appLawyerService.updateAppLawyer(appLawyer));
    }

    /**
     * 删除律师信息
     */
    @PreAuthorize("@ss.hasPermi('app:lawyer:remove')")
    @Log(title = "律师信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{lawyerIds}")
    public AjaxResult remove(@PathVariable Long[] lawyerIds) {
        return toAjax(appLawyerService.deleteAppLawyerByLawyerIds(lawyerIds));
    }
}
