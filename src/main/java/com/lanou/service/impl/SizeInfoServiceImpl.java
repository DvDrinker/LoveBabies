package com.lanou.service.impl;

import com.lanou.dao.SizeInfoMapper;
import com.lanou.entity.SizeInfo;
import com.lanou.service.SizeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/8.
 */
@Service("sizeInfoServive")
public class SizeInfoServiceImpl implements SizeInfoService{
    @Autowired
    private SizeInfoMapper sizeInfoMapper;

    public List<SizeInfo> findSizeInfoByGoodsId(Integer goodsId) {
        return sizeInfoMapper.findSizeInfoByGoodsId(goodsId);
    }
}
