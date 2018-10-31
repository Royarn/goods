package com.royarn.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@EnableTransactionManagement(order = 10)
@SpringBootApplication
@MapperScan(basePackages = {"com.royarn.goods.dao"})
public class GoodsApplication {

	public static void main(String[] args) {

	    ApplicationContext context = SpringApplication.run(GoodsApplication.class, args);
	    //get all bean from IOC
	    /**String[] strings = context.getBeanDefinitionNames();
        Arrays.asList(strings).stream()
                .forEach(string -> System.out.println("bean : " + string));*/

        //get service bean from IOC, also you can get controller bean from IOC
        String[] serviceBeans = context.getBeanNamesForAnnotation(Service.class);
        Arrays.asList(serviceBeans).stream()
                .forEach(string -> System.out.println("service bean : " + string));
	}
}
