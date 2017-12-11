package com.lanou.service.impl;

import com.lanou.dao.ClassifyMapper;
import com.lanou.entity.Classify;
import com.lanou.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public Classify findSimpleById(Integer classifyId) {
        return classifyMapper.findSimpleById(classifyId);
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

    //根据id查找所有三级分类id
    @Transactional
    public List<Integer> findAllThirdId(Integer classifyId) {
        List<Integer> thirdIdList=new ArrayList<Integer>();
        List<Classify>  classifies=findChildById(classifyId);
        if (classifies.size()==0){
            thirdIdList.add(classifyId);
        }
        for (int i = 0; i <classifies.size() ; i++) {
            if (classifies.get(i).getClassifies().size() !=0){
                List<Classify>  classifies2=classifies.get(i).getClassifies();
                for (int j = 0; j <classifies2.size() ; j++) {
                    thirdIdList.add(classifies2.get(j).getClassifyId());
                }
            }else{
                thirdIdList.add(classifies.get(i).getClassifyId());
            }
        }
        return thirdIdList;
    }

    //根据一级分类id查找所有三级分类
    @Transactional
    public List<Classify> findAllThirdName(Integer classifyId) {
        List<Classify> ThirdList=new ArrayList<Classify>();
        List<Classify>  classifies=findChildById(classifyId);
        for (int i = 0; i < classifies.size(); i++) {
            List<Classify>  classifies2=classifies.get(i).getClassifies();
            for(int j=0;j<classifies2.size();j++){
                ThirdList.add(classifies2.get(j));
            }
        }
        return ThirdList;
    }

    public List<Integer> findByParentId() {
        List<Integer> thirdIdList=new ArrayList<Integer>();
        List<Classify> classifies=classifyMapper.findByParentId();
        for (int i = 0; i <classifies.size() ; i++) {
            Classify classify=classifies.get(i);
            List<Classify> classifies1=findAllThirdName(classify.getClassifyId());
            for (int j = 0; j <classifies1.size() ; j++) {
               thirdIdList.add(classifies1.get(j).getClassifyId());
            }
        }
        return thirdIdList;
    }


    public Classify findClassifyByParentId(Classify classify){
        Classify classify1 =classifyMapper.findClassifyByParentId(classify.getClassifyParentId());
        return classify1;
    }

    public List<Classify> findByThirdId(Integer classifyId) {
        List<Classify> classifyNameList=new ArrayList<Classify>();
        Classify classify=classifyMapper.findById(classifyId);
        Classify classify1=findClassifyByParentId(classify);
        Classify classify2=findClassifyByParentId(classify1);
        classifyNameList.add(classify2);
        classifyNameList.add(classify1);
        classifyNameList.add(classify);
        return classifyNameList;
    }

    public int insertClassify(Integer classifyId, String classifyName) {
        //List<Classify> classifies=findFirstClassify(0);
        //List<Classify> classifies1=classifyMapper.findChildById(classifyId);
        int result=classifyMapper.insertClassify(classifyName,classifyId);
        return result;
    }



}
