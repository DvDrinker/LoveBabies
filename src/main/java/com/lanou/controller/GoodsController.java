package com.lanou.controller;

import com.lanou.service.ClassifyService;
import com.lanou.service.GoodsService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by lanou on 2017/12/4.
 */
@RequestMapping("/goods")
@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ClassifyService classifyService;

    @RequestMapping(value = "/findGoods.do")
    public String findGoods(HttpServletResponse response){
        FastJson.toJson(goodsService.findGoods(),response);
        return "index";
    }

    @RequestMapping(value = "/findGoodsByClassify")
    public  String findGoodsByClassify(HttpServletResponse response,Integer classifyId){
        FastJson.toJson(classifyService.findAllThirdId(classifyId),response);
        return "index";
    }

}
