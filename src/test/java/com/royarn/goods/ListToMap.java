package com.royarn.goods;

import com.royarn.goods.config.BeanConfig;
import com.royarn.goods.service.GeneralService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author dell
 * @date 2018-10-31
 */
public class ListToMap {

    public static void main(String[] args) {
        Map<Integer, Obj> map = Arrays.asList(new Obj(1, "royarn"),
                new Obj(2, "blink"),
                new Obj(3, "seven"),
                new Obj(4, "shadow")).stream()
                .collect(Collectors.toMap(Obj::getId, a -> a, (k1, k2) -> k1));
        System.out.println(map);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        GeneralService service = (GeneralService) context.getBean("service");
        System.out.println(service.qryData());
    }
}

class Obj {

    private Integer id;
    private String name;

    public Obj(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{ id : " + id + ", name : " + name + " }";
    }
}
