package com.royarn.goods.controller;

import com.royarn.api.entity.Store;
import com.royarn.api.intf.StoreService;
import com.royarn.goods.config.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
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
@RequestMapping("/store")
public class StoreController {

    @Resource
    private StoreService service;

    @ApiOperation("库存列表")
    @GetMapping("/list")
    public Result list() {
        return Result.ok().property("stores", service.list());
    }

    @ApiOperation("查询库存")
    @PostMapping("/get")
    public Result get(@RequestBody List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Result.error("库存ID不能为空！");
        }
        return Result.ok().property("stores", service.get(ids));
    }

    @ApiOperation("添加库存")
    @PostMapping("/add")
    public Result add(@RequestBody Store store) {
        return Result.ok().property("store", service.insert(store));
    }

    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public Result batch(@RequestBody List<Store> stores) {
        if (CollectionUtils.isEmpty(stores)) {
            return Result.error("库存信息不能为空！");
        }
        return Result.ok().property("stores", service.batchInsert(stores));
    }

    @ApiOperation("修改库存")
    @PostMapping("/update")
    public Result update(@RequestBody Store store) {
        return Result.ok().property("store", service.update(store));
    }

    @ApiOperation("删除库存")
    @PostMapping("/delete")
    public Result delete(@RequestBody List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Result.error("库存ID不能为空！");
        }
        return Result.ok().property("ids", service.delete(ids));
    }
}
