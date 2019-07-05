package com.royarn.goods.config;

import com.royarn.goods.service.GeneralService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * spring 注解式配置
 * @author lizhiqiang
 * @date 2019-06-05
 */
@Configuration
public class BeanConfig {

    @Bean
    public GeneralService service() {
        return new GeneralService();
    }
}
