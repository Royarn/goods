package com.royarn.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.royarn.api.entity.Classify;
import com.royarn.api.intf.ClassifyService;
import com.royarn.goods.dao.ClassifyMapper;
import com.royarn.goods.entity.ClassifyExample;
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
public class ClassifyServiceImpl implements ClassifyService {

    @Resource
    private ClassifyMapper mapper;

    @Override
    public List<Classify> get(List<String> ids) {
        ClassifyExample example = new ClassifyExample();
        ClassifyExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return mapper.selectByExample(example);
    }

    @Override
    public List<Classify> list() {
        return mapper.selectByExample(null);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public int insert(Classify classify) {
        ClassifyExample example = new ClassifyExample();
        ClassifyExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(classify.getName());
        List<Classify> classifies = mapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(classifies)) {
            throw new BusinessException("分类已存在！");
        }
        classify.setId(UUID.randomUUID().toString());
        return mapper.insert(classify);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public List<Classify> batchInsert(List<Classify> classifies) {
        classifies = classifies.stream()
                .map(classify -> {
                    classify.setId(UUID.randomUUID().toString());
                    return classify;})
                .collect(Collectors.toList());
        mapper.batchInsert(classifies);
        return classifies;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public Classify update(Classify classify) {
        ClassifyExample example = new ClassifyExample();
        ClassifyExample.Criteria criteria = example.createCriteria();
        criteria.andIdNotEqualTo(classify.getId());
        criteria.andNameEqualTo(classify.getName());
        List<Classify> classifies = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(classifies)) {
            throw new BusinessException("分类已存在！");
        }
        mapper.updateByPrimaryKey(classify);
        return classify;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = BusinessException.class)
    public int delete(List<String> ids) {
        ClassifyExample example = new ClassifyExample();
        ClassifyExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return mapper.deleteByExample(example);
    }
}
