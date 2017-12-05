package com.lanou.controller;

import com.lanou.entity.Goods;
import com.lanou.service.ClassifyService;
import com.lanou.service.GoodsService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public void findGoods(HttpServletResponse response){
        FastJson.toJson(goodsService.findGoods(),response);

    }

    @RequestMapping(value = "/findGoodsByClassify")
    public  void findGoodsByClassify(HttpServletResponse response,Integer classifyId,Integer sequence){
        List<Integer> classifyIds = classifyService.findAllThirdId(classifyId);

        if ( sequence == null ){
            sequence = 1;

        }
        System.out.println(sequence);
        List<Goods> goodsList = goodsService.findGoodsByClassifyId(classifyIds,sequence);
        FastJson.toJson(goodsList,response);


    }




}
