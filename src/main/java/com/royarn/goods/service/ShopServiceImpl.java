package com.royarn.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.royarn.api.entity.Shop;
import com.royarn.api.intf.ShopService;
import com.royarn.goods.dao.ShopMapper;
import com.royarn.goods.entity.ShopExample;
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
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopMapper mapper;

    @Override
    public List<Shop> get(List<String> ids) {
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return mapper.selectByExample(example);
    }

    @Override
    public List<Shop> list() {
        return mapper.selectByExample(null);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public int insert(Shop shop) {
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(shop.getName());
        List<Shop> goods = mapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(goods)) {
            throw new BusinessException("商家已注册!");
        }
        shop.setId(UUID.randomUUID().toString());
        return mapper.insert(shop);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public List<Shop> batchInsert(List<Shop> shops) {
        shops = shops.stream()
                .map(shop -> {
                    shop.setId(UUID.randomUUID().toString());
                    return shop;
                })
                .collect(Collectors.toList());
        mapper.batchInsert(shops);
        return shops;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public Shop update(Shop shop) {
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        criteria.andIdNotEqualTo(shop.getId());
        criteria.andNameEqualTo(shop.getName());
        List<Shop> goods = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(goods)) {
            throw new BusinessException("商家已存在！");
        }
        mapper.updateByPrimaryKey(shop);
        return shop;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public int delete(List<String> ids) {
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return mapper.deleteByExample(example);
    }
}
