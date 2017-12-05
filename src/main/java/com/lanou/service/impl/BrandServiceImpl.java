package com.lanou.service.impl;

import com.lanou.dao.BrandMapper;
import com.lanou.entity.Brand;
import com.lanou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandMapper brandMapper;

    @Transactional
    public List<Brand> findBrandByClassifyId(Integer classifyId) {
        List<Brand> brands=brandMapper.findBrandByClassifyId(classifyId);
        return brands;
    }
}
