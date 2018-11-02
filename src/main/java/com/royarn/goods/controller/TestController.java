package com.royarn.goods.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.royarn.api.intf.MiniService;
import com.royarn.goods.config.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author dell
 * @date 2018-11-02
 */
@RestController
@RequestMapping("/mini")
public class TestController {

    @Reference
    private MiniService service;

    @ApiOperation("测试接口")
    @GetMapping("/test")
    public Result get() {
        return Result.ok().property("data", service.sayHello("dsfsdfs"));
    }
}
