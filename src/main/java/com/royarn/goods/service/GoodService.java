package com.royarn.goods.service;

import com.royarn.goods.entity.Good;

import java.util.List;

/**
 * Description:
 *
 * @author dell
 * @date 2018-10-30
 */
public interface GoodService {
    /**
     * @param user
     * @return
     */
    List<Good> get(List<String> ids);

    /**
     *
     * @return
     */
    List<Good> list();

    /**
     *
     * @param user
     * @return
     */
    int insert(Good user);

    /**
     * @param users
     * @return
     */
    List<Good> batchInsert(List<Good> users);

    /**
     * @param user
     * @return
     */
    Good update(Good user);

    /**
     * @param ids
     * @return
     */
    int delete(List<String> ids);
}
