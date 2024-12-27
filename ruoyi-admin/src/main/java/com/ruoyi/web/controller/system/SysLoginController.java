package com.ruoyi.web.controller.system;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.domain.WxLoginForm;
import com.ruoyi.system.domain.WxLoginResponseBody;
import com.ruoyi.system.service.ISysMenuService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@RestController
public class SysLoginController extends BaseController {

    @Autowired
    private ISysUserService userService;


    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        if (!loginUser.getPermissions().equals(permissions)) {
            loginUser.setPermissions(permissions);
            tokenService.refreshToken(loginUser);
        }
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters() {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }

    /**
     * 微信一键登录，获取 WX OpenId
     * <p>
     * // 获取 OpenId，如果存在OpenId 用户，则加载用户数据，如果不存在则创建一个新用户
     *
     * @param wxLoginForm 微信登录参数
     * @return
     */
    @PostMapping("/wxAppLogin")
    public AjaxResult wxAppLogin(@RequestBody WxLoginForm wxLoginForm) {
        AjaxResult ajaxResult = AjaxResult.success();
        // 第一阶段，获取用户ID
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        url += "?appid=wx8e6d72c91e6995f5&" +
                "secret=1101a2e25169aff9525be38d2f9b4244&" +
                "js_code=" + wxLoginForm.getCode() +
                "&grant_type=authorization_code";
        String resp = HttpUtils.sendGet(url);
        WxLoginResponseBody wxLoginResponseBody = JSON.parseObject(resp, WxLoginResponseBody.class);
        ajaxResult.put("sessionKey", wxLoginResponseBody.getSession_key());
        String wxOpenId = wxLoginResponseBody.getOpenid();
        ajaxResult.put("openId", wxOpenId);
        // 第二阶段，判断是否存在此用户，如不存在则创建新用户，如存在则返回用户信息
        SysUser user = new SysUser();
        user.setUserName(wxOpenId.substring(0, 6));
        user.setNickName("微信用户:" + wxOpenId.substring(0, 6));
        user.setWxOpenId(wxOpenId);
        String password = "qwert12345!@#$%";
        if (!userService.checkWxOpenIdUnique(user)) {
            error("新增微信用户'" + user.getWxOpenId() + "'失败，登录账号已存在");
        } else {
            //
            user.setCreateBy("admin");
            user.setPassword(SecurityUtils.encryptPassword(password));
            userService.insertUser(user);
        }
        // 进行 系统登录
        // 生成令牌
        String token = loginService.login(user.getUserName(), password);
        AjaxResult ajax = AjaxResult.success("登录成功！", user);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

}
