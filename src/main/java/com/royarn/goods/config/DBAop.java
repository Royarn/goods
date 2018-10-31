package com.royarn.goods.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/6/28 11:11
 */
@Aspect
@Component
public class DBAop implements PriorityOrdered {

    private Logger logger = LoggerFactory.getLogger(DBAop.class);

    @Before("execution(* com.royarn.goods.service..*.list*(..)) || execution(* com.royarn.goods.service..*.get*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        logger.info("切换数据库到read ... ");
    }

    @Before("execution(* com.royarn.goods.service..*.insert*(..)) || execution(* com.royarn.goods.service..*.batch*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        logger.info("切换数据库到write ... ");
    }

    @Before("execution(* com.royarn.goods.service..*.update*(..)) || execution(* com.royarn.goods.service..*.delete*(..))")
    public void setWriteDataSourceTypes() {
        DataSourceContextHolder.write();
        logger.info("切换数据库到write ... ");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}