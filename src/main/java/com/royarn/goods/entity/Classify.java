package com.royarn.goods.entity;

public class Classify {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_classify.id
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_classify.name
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_classify.id
     *
     * @return the value of t_classify.id
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_classify.id
     *
     * @param id the value for t_classify.id
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_classify.name
     *
     * @return the value of t_classify.name
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_classify.name
     *
     * @param name the value for t_classify.name
     *
     * @mbggenerated Tue Oct 30 15:18:51 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}