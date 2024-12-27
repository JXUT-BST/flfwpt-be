package com.ruoyi.web.controller.wxapp;

import com.ruoyi.app.domain.AppLawfirm;
import com.ruoyi.app.service.IAppLawfirmService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 微信接口 公开接口
 */
@RestController
@RequestMapping("/wxapp-openapi")
public class WxAppController extends BaseController {

    @Autowired
    private IAppLawfirmService appLawfirmService;

    /**
     * 查询律所信息列表
     */
    @GetMapping("/app/lawfirm/list")
    public TableDataInfo appLawfirmList(AppLawfirm appLawfirm) {
        startPage();
        List<AppLawfirm> list = appLawfirmService.selectAppLawfirmList(appLawfirm);
        return getDataTable(list);
    }
}
