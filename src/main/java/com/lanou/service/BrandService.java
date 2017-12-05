package com.lanou.service;

import com.lanou.entity.Brand;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
public interface BrandService {

    public List<Brand> findBrandByClassifyId(Integer classifyId);

}
