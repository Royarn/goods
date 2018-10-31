package com.royarn.goods.service;

import com.royarn.goods.entity.Classify;

import java.util.List;

/**
 * Description:
 *
 * @author dell
 * @date 2018-10-30
 */
public interface ClassifyService {
    /**
     * @param user
     * @return
     */
    List<Classify> get(List<String> ids);

    /**
     *
     * @return
     */
    List<Classify> list();

    /**
     *
     * @param user
     * @return
     */
    int insert(Classify user);

    /**
     * @param users
     * @return
     */
    List<Classify> batchInsert(List<Classify> users);

    /**
     * @param user
     * @return
     */
    Classify update(Classify user);

    /**
     * @param ids
     * @return
     */
    int delete(List<String> ids);
}
