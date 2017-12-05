package com.lanou.dao;

import com.lanou.entity.Citys;

import java.util.List;

/**
 * Created by lanou on 2017/12/4.
 */
public interface  CitysMapper {
    public  List<Citys> selectCitys(Integer parentId);
}
