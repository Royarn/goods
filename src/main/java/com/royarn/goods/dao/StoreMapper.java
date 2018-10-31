package com.royarn.goods.dao;

import com.royarn.goods.entity.Store;
import com.royarn.goods.entity.StoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int countByExample(StoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int deleteByExample(StoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int insert(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int insertSelective(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    List<Store> selectByExample(StoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    Store selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int updateByPrimaryKeySelective(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int updateByPrimaryKey(Store record);

    int batchInsert(@Param("stores") List<Store> stores);
}