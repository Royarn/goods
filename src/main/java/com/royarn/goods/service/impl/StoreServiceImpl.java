package com.royarn.goods.service.impl;

import com.royarn.goods.dao.StoreMapper;
import com.royarn.goods.entity.Store;
import com.royarn.goods.entity.StoreExample;
import com.royarn.goods.service.StoreService;
import com.royarn.goods.support.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author dell
 * @date 2018-10-30
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    private StoreMapper mapper;

    @Override
    public List<Store> get(List<String> ids) {
        StoreExample example = new StoreExample();
        StoreExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return mapper.selectByExample(example);
    }

    @Override
    public List<Store> list() {
        return mapper.selectByExample(null);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public int insert(Store store) {
        StoreExample example = new StoreExample();
        StoreExample.Criteria criteria = example.createCriteria();
        criteria.andGoodIdEqualTo(store.getGoodId());
        List<Store> stores = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(stores)) {
            return mapper.insert(store);
        }
        return 0;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public List<Store> batchInsert(List<Store> stores) {
        Map<String, Store> storeMap = stores.stream()
                .collect(Collectors.toMap(Store::getGoodId, a -> a, (k1, k2) -> k1));
        StoreExample example = new StoreExample();
        StoreExample.Criteria criteria = example.createCriteria();
        criteria.andGoodIdIn(new ArrayList<>(storeMap.keySet()));
        List<Store> existStores = mapper.selectByExample(example);
        //transfer list to map
        Map<String, Store> existMap = existStores.stream()
                .collect(Collectors.toMap(Store::getGoodId, a -> a, (k1, k2) -> k1));
        //filter data
        List<Store> realStores = storeMap.keySet().stream()
                .filter(s -> !existMap.containsKey(s))
                .map(s -> {
                    Store store = storeMap.get(s);
                    store.setId(UUID.randomUUID().toString());
                    return store;
                    })
                .collect(Collectors.toList());
        mapper.batchInsert(realStores);
        return realStores;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public Store update(Store store) {
        if (null == store.getNum() || store.getNum() < 0) {
            throw new BusinessException("库存数量有误！");
        }
        mapper.updateByPrimaryKey(store);
        return store;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public int delete(List<String> ids) {
        StoreExample example = new StoreExample();
        StoreExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return mapper.deleteByExample(example);
    }
}
