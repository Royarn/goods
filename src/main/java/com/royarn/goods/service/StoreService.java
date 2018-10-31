package com.royarn.goods.service;

import com.royarn.goods.entity.Store;

import java.util.List;

/**
 * Description:
 *
 * @author dell
 * @date 2018-10-30
 */
public interface StoreService {
    /**
     * @param user
     * @return
     */
    List<Store> get(List<String> ids);

    /**
     *
     * @return
     */
    List<Store> list();

    /**
     *
     * @param user
     * @return
     */
    int insert(Store user);

    /**
     * @param users
     * @return
     */
    List<Store> batchInsert(List<Store> users);

    /**
     * @param user
     * @return
     */
    Store update(Store user);

    /**
     * @param ids
     * @return
     */
    int delete(List<String> ids);
}
