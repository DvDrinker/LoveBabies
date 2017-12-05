package com.lanou.service;

import com.lanou.entity.Citys;

import java.util.List;

/**
 * Created by lanou on 2017/12/4.
 */
public interface CitysService {
    public List<Citys> selectCitys(Integer parentId);
}
