package com.royarn.goods.controller;

import com.royarn.goods.config.Result;
import com.royarn.goods.service.CameraService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author dell
 * @date 2018-12-28
 */
@RestController
@RequestMapping("/import")
public class ImportToolController {

    @Resource
    private CameraService service;

    @ApiOperation("摄像机列表")
    @GetMapping("/list")
    public Result list() {
        return Result.ok().property("list", service.list());
    }
}
