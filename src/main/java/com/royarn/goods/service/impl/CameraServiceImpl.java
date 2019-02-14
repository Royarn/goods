package com.royarn.goods.service.impl;

import com.royarn.goods.dao.CameraMapper;
import com.royarn.goods.entity.Camera;
import com.royarn.goods.service.CameraService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author dell
 * @date 2018-12-28
 */
@Service
public class CameraServiceImpl implements CameraService {

    @Resource
    private CameraMapper mapper;

    @Override
    public List<Camera> list() {
        return mapper.selectByExample(null);
    }
}
