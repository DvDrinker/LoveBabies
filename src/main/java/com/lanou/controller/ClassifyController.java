package com.lanou.controller;

import com.lanou.entity.Classify;
import com.lanou.service.ClassifyService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
@Controller
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    //查找一级分类
    @RequestMapping("/findFirstClassify.do")
    public void findFirstClassify(Integer classifyParentId,HttpServletResponse response){

        List<Classify> classifies=classifyService.findFirstClassify(classifyParentId);
        System.out.print("classifies:"+classifies);
        FastJson.toJson(classifies,response);

    }

    //查找所有分类
    @RequestMapping("/findClassify.do")
    public void findClassify(Integer classifyId,HttpServletResponse response){

        Classify classify=classifyService.findById(classifyId);
        System.out.print("classify:"+classify);
        FastJson.toJson(classify,response);

    }

    @RequestMapping("/findByThirdId.do")
    public void findByThirdId(Integer classifyId,HttpServletResponse response){
        List<String> classifyNameList=classifyService.findByThirdId(classifyId);
        System.out.println("classifyNameList:"+classifyNameList);
        FastJson.toJson(classifyNameList,response);
    }

}
