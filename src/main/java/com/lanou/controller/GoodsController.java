package com.lanou.controller;

import com.lanou.entity.Goods;
import com.lanou.entity.GoodsConditionList;
import com.lanou.service.ClassifyService;
import com.lanou.service.GoodsConditionService;
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
    @Autowired
    private GoodsConditionService goodsConditionService;

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

    @RequestMapping(value = "getGoodsById")
    public void getGoodsById(HttpServletResponse response,Integer goodsId){
        Goods goods = goodsService.findGoodsByGoodsId(goodsId);
        FastJson.toJson(goods,response);

    }

    @RequestMapping(value = "getGoodsByAllConditions.do")
    public void getGoodsByConditions(HttpServletResponse response,//响应；返回json用
                                     Integer classifyId,//分类id
                                     String keyword,//模糊查询关键字
                                     GoodsConditionList conditions,//筛选条件：属性名与属性值
                                     Integer page,//当前页数：
                                     Integer sequence//顺序参数
    ){



        List<Integer> classifyIds = classifyService.findAllThirdId(classifyId);//根据classifyId得到所有的三级分类
        System.out.println(sequence);
        List<Goods> goodsList = goodsService.findGoodsByOneClassifyId(classifyIds);//根据得到的三级分类Id集合查询出所有的商品信息

        List<Goods> goodsList1 = goodsService.findLikeKeyword(keyword,goodsList);//根据上一步操作得到的list，取出其中符合模糊查询的部分
        System.out.println("smqsmq");
        FastJson.toJson(goodsList1,response);



//        if ( sequence == null ){
//            sequence = 1;
//
//        }//默认按照id排序

        //传入数组
//        List<Integer> integerList = new ArrayList<Integer>();
//        for (int i = 0; i < goodsIds.length; i++) {
//            integerList.add(goodsIds[i]);
//        }
//
//        List<Integer> integers = goodsConditionService.getGoodsIdByCondition(conditionName,conditionvalue,integerList);
//
//
//        FastJson.toJson(integers,response);

//      需要放到map中的对象有商品集合，分页对象，筛选表
    }




}
