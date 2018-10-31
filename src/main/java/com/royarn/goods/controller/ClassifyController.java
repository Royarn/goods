package com.royarn.goods.controller;

import com.royarn.goods.config.Result;
import com.royarn.goods.entity.Classify;
import com.royarn.goods.service.ClassifyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Description:
 *
 * @author dell
 * @date 2018-10-30
 */

@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Resource
    private ClassifyService service;

    @ApiOperation("分类列表")
    @GetMapping("/list")
    public Result list() {
        return Result.ok().property("classifies", service.list());
    }

    @ApiOperation("查询分类")
    @PostMapping("/get")
    public Result get(@RequestBody List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Result.error("分类ID不能为空！");
        }
        return Result.ok().property("classifies", service.get(ids));
    }

    @ApiOperation("添加分类")
    @PostMapping("/add")
    public Result add(@RequestBody Classify classify) {
       if (StringUtils.isEmpty(classify.getName())) {
           return Result.error("分类名称不能为空！");
       }
       return Result.ok().property("classify", service.insert(classify));
    }

    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public Result batch(@RequestBody List<Classify> classifies) {
        if (CollectionUtils.isEmpty(classifies)) {
            return Result.error("分类信息不能为空！");
        }
        return Result.ok().property("classifies", service.batchInsert(classifies));
    }

    @ApiOperation("更新分类")
    @PostMapping("/update")
    public Result update(@RequestBody Classify classify) {
        if (StringUtils.isEmpty(classify.getId())) {
            return Result.error("分类ID不能为空！");
        }
        return Result.ok().property("classify", service.update(classify));
    }

    @ApiOperation("删除分类")
    @PostMapping("/delete")
    public Result delete(@RequestBody List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Result.error("分类信息不能为空！");
        }
        return Result.ok().property("ids", service.delete(ids));
    }
}

