package com.royarn.goods.dao;

import com.royarn.goods.entity.Classify;
import com.royarn.goods.entity.ClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassifyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int countByExample(ClassifyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int deleteByExample(ClassifyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int insert(Classify record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int insertSelective(Classify record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    List<Classify> selectByExample(ClassifyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    Classify selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int updateByExampleSelective(@Param("record") Classify record, @Param("example") ClassifyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int updateByExample(@Param("record") Classify record, @Param("example") ClassifyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int updateByPrimaryKeySelective(Classify record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_classify
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    int updateByPrimaryKey(Classify record);

    int batchInsert(@Param("classifies") List<Classify> classifies);
}