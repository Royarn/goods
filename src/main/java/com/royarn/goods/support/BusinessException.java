package com.royarn.goods.support;

/**
 * Description:
 *
 * @author dell
 * @date 2018-10-30
 */
public class BusinessException extends RuntimeException {

    /**
     * 异常信息描述
     */
    private String message;

    public BusinessException(String message) {
        super(message);
    }
}
