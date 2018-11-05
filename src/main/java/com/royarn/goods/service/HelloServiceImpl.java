package com.royarn.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.royarn.api.intf.HelloService;

/**
 * Description:
 *
 * @author dell
 * @date 2018-11-01
 */

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String s) {
        return "Hello Dubbo";
    }

    @Override
    public String testDTS() {
        return null;
    }
}