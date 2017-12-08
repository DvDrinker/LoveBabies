package com.lanou.dao;

import com.lanou.entity.SizeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lanou on 2017/12/8.
 */
public interface SizeInfoMapper {
    public List<SizeInfo> findSizeInfoByGoodsId(@Param("goodsId") Integer goodsId);
}
