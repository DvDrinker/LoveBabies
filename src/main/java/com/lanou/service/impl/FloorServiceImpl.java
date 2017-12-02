package com.lanou.service.impl;

import com.lanou.dao.FloorMapper;
import com.lanou.entity.Floor;
import com.lanou.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
@Service("floorService")
public class FloorServiceImpl implements FloorService{
    @Autowired
    private FloorMapper floorMapper;
    //查找所有楼层
    @Transactional
    public List<Floor> findAllFloor() {

        List<Floor> floors=floorMapper.findAllFloor();

        return floors;
    }
}
