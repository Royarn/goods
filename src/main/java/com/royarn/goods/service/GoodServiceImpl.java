package com.royarn.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.royarn.api.entity.Good;
import com.royarn.api.intf.GoodService;
import com.royarn.goods.dao.GoodMapper;
import com.royarn.goods.entity.GoodExample;
import com.royarn.goods.support.BusinessException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author dell
 * @date 2018-10-30
 */

@Service
public class GoodServiceImpl implements GoodService {

    @Resource
    private GoodMapper mapper;

    @Override
    public List<Good> get(List<String> ids) {
        GoodExample example = new GoodExample();
        GoodExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return mapper.selectByExample(example);
    }

    @Override
    public List<Good> list() {
        return mapper.selectByExample(null);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public int insert(Good good) {
        GoodExample example = new GoodExample();
        GoodExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(good.getName());
        List<Good> goods = mapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(goods)) {
            throw new BusinessException("商品已存在!");
        }
        good.setId(UUID.randomUUID().toString());
        return mapper.insert(good);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public List<Good> batchInsert(List<Good> goods) {
        goods = goods.stream()
                .map(good -> {
                 good.setId(UUID.randomUUID().toString());
                 return good;
                })
                .collect(Collectors.toList());
        mapper.batchInsert(goods);
        return goods;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public Good update(Good good) {
        GoodExample example = new GoodExample();
        GoodExample.Criteria criteria = example.createCriteria();
        criteria.andIdNotEqualTo(good.getId());
        criteria.andNameEqualTo(good.getName());
        List<Good> goods = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(goods)) {
            throw new BusinessException("商品已存在！");
        }
        mapper.updateByPrimaryKey(good);
        return good;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public int delete(List<String> ids) {
        GoodExample example = new GoodExample();
        GoodExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return mapper.deleteByExample(example);
    }
}
