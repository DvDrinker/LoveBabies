package com.lanou.service;

import com.lanou.entity.SizeInfo;

import java.util.List;

/**
 * Created by lanou on 2017/12/8.
 */
public interface SizeInfoService {

    public List<SizeInfo> findSizeInfoByGoodsId(Integer goodsId);
}
