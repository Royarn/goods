package com.royarn.goods.dao;

import com.royarn.goods.entity.Group;
import com.royarn.goods.entity.GroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int countByExample(GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int deleteByExample(GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int insert(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int insertSelective(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    List<Group> selectByExample(GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    Group selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int updateByPrimaryKeySelective(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table other_groups
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int updateByPrimaryKey(Group record);
}