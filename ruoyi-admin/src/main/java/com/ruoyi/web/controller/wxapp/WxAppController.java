package com.ruoyi.web.controller.wxapp;

import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信接口
 */
@RestController
@RequestMapping("/wxapp")
public class WxAppController {

    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name;
    }
}
