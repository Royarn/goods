package com.royarn.goods;

import com.alibaba.fastjson.JSON;

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
        System.out.println(map.get(1));
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
