package com.royarn.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.royarn.api.intf.HelloService;
import com.royarn.goods.dao.GoodMapper;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author dell
 * @date 2018-11-01
 */

@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    private GoodMapper mapper;

    @Override
    public String sayHello(String s) {
        return "Hello Dubbo";
    }
}