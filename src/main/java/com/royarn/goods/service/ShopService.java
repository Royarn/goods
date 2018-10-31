package com.royarn.goods.service;

import com.royarn.goods.entity.Shop;

import java.util.List;

/**
 * Description:
 *
 * @author dell
 * @date 2018-10-30
 */
public interface ShopService {

    /**
     * @param user
     * @return
     */
    List<Shop> get(List<String> ids);

    /**
     *
     * @return
     */
    List<Shop> list();

    /**
     *
     * @param user
     * @return
     */
    int insert(Shop user);

    /**
     * @param users
     * @return
     */
    List<Shop> batchInsert(List<Shop> users);

    /**
     * @param user
     * @return
     */
    Shop update(Shop user);

    /**
     * @param ids
     * @return
     */
    int delete(List<String> ids);
}
