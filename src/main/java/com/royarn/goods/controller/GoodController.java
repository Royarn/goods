package com.royarn.goods.controller;

import com.royarn.goods.config.Result;
import com.royarn.goods.entity.Good;
import com.royarn.goods.service.GoodService;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author dell
 * @date 2018-10-30
 */

@RestController
@RequestMapping("/good")
public class GoodController {

    @Resource
    private GoodService service;

    @ApiOperation("商品列表")
    @GetMapping("/list")
    public Result list() {
        return Result.ok().property("goods", service.list());
    }

    @ApiOperation("查询商品")
    @PostMapping("/get")
    public Result get(@RequestBody List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Result.error("商品ID不能为空！");
        }
        return Result.ok().property("goods", service.get(ids));
    }

    @ApiOperation("添加商品")
    @PostMapping("/add")
    public Result add(@RequestBody Good good) {
        if (null == good || StringUtils.isEmpty(good.getName())) {
            return Result.error("商品信息不能为空！");
        }
        return Result.ok().property("good", service.insert(good));
    }

    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public Result batch(@RequestBody List<Good> goods) {
        if (CollectionUtils.isEmpty(goods)) {
            return Result.error("商品信息为空！");
        }
        return Result.ok().property("goods", service.batchInsert(goods));
    }

    @ApiOperation("修改商品")
    @PostMapping("/update")
    public Result update(@RequestBody Good good) {
        if (StringUtils.isEmpty(good.getId())) {
            return Result.error("商品ID不能为空！");
        }
        return Result.ok().property("good", service.update(good));
    }


    public Result delete(@RequestBody List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Result.error("商品ID不能为空！");
        }
        return Result.ok().property("ids", service.delete(ids));
    }
}