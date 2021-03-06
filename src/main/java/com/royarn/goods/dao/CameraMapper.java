package com.royarn.goods.dao;

import com.royarn.goods.entity.Camera;
import com.royarn.goods.entity.CameraExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CameraMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int countByExample(CameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int deleteByExample(CameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int insert(Camera record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int insertSelective(Camera record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    List<Camera> selectByExampleWithBLOBs(CameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    List<Camera> selectByExample(CameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    Camera selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") Camera record, @Param("example") CameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") Camera record, @Param("example") CameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int updateByExample(@Param("record") Camera record, @Param("example") CameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int updateByPrimaryKeySelective(Camera record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Camera record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_device_camera
     *
     * @mbggenerated Tue Feb 19 14:59:51 CST 2019
     */
    int updateByPrimaryKey(Camera record);
}