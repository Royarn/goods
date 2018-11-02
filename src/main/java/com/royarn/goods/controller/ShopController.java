package com.royarn.goods.controller;

import com.royarn.api.entity.Shop;
import com.royarn.api.intf.ShopService;
import com.royarn.goods.config.Result;
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
 * @date 2018-10-31
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Resource
    private ShopService service;

    @ApiOperation("商家列表")
    @GetMapping("/list")
    public Result list() {
        return Result.ok().property("shops", service.list());
    }

    @ApiOperation("查询商家")
    @PostMapping("/get")
    public Result get(@RequestBody List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Result.error("商家iD不能为空！");
        }
        return Result.ok().property("shops", service.get(ids));
    }

    @ApiOperation("添加商家")
    @PostMapping("/add")
    public Result add(@RequestBody Shop shop) {
        if (StringUtils.isEmpty(shop.getName())) {
            return Result.error("商家名称不能为空！");
        }
        return Result.ok().property("shop", service.insert(shop));
    }

    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public Result batch(@RequestBody List<Shop> shops) {
        if (CollectionUtils.isEmpty(shops)) {
            return Result.error("商家信息不能为空！");
        }
        return Result.ok().property("shops", service.batchInsert(shops));
    }

    @ApiOperation("修改商家")
    @PostMapping("/update")
    public Result update(@RequestBody Shop shop) {
        return Result.ok().property("shop", service.update(shop));
    }

    @ApiOperation("删除商家")
    @PostMapping("/delete")
    public Result delete(@RequestBody List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Result.error("商家ID不能为空！");
        }
        return Result.ok().property("ids", service.delete(ids));
    }
}