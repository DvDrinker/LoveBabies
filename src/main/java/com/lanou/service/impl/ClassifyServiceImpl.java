package com.lanou.service.impl;

import com.lanou.dao.ClassifyMapper;
import com.lanou.entity.Classify;
import com.lanou.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
@Service("classifyService")
public class ClassifyServiceImpl implements ClassifyService{
    @Autowired
    private ClassifyMapper classifyMapper;
    //查找所有一级分类
    @Transactional
    public List<Classify> findFirstClassify(Integer classifyParentId) {
        List<Classify> classifies=classifyMapper.findFirstClassify(classifyParentId);
        return classifies;
    }

    //根据id查找一级分类及其子分类
    @Transactional
    public Classify findById(Integer classifyId) {
        Classify classify=classifyMapper.findById(classifyId);
        if (classify==null){
            return null;
        }
        classify.setClassifies(findChildById(classifyId));
        return classify;
    }


    //查找所有子分类
    @Transactional
    public List<Classify> findChildById(Integer classifyId) {
        List<Classify>  classifies=classifyMapper.findChildById(classifyId);
        for (Classify classify: classifies) {
            classify.setClassifies(findChildById(classify.getClassifyId()));
        }
        return classifies;
    }
}
