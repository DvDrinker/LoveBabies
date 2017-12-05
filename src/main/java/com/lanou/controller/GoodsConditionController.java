package com.lanou.controller;

import com.lanou.entity.Goods;
import com.lanou.entity.GoodsCondition;
import com.lanou.entity.GoodsList;
import com.lanou.service.GoodsConditionService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2017/12/1.
 */
@RequestMapping("/condition")
@Controller
public class GoodsConditionController {
    @Autowired
    private GoodsConditionService goodsConditionService;

    @RequestMapping("/finds.do")
    public String finds(Model model){
        List<GoodsCondition> conditions = goodsConditionService.findConditions();
        System.out.println("concccc"+conditions);
        model.addAttribute("conditions",conditions);
        return "index";
    }


//  如果不加produces中属性，将会出现中文乱码问题

    @RequestMapping(value = "/findByGoods_id.do")
    public void finds(Integer goods_id, HttpServletResponse response){
        List<GoodsCondition> conditions = goodsConditionService.findConditionsByGoods_id(goods_id);
        FastJson.toJson(conditions,response);

    }


//  要接受基本数据类型的集合，使用数组接收即可
    @RequestMapping(value = "/createConditionTable.do")
    public void createTable(Integer[] goods_ids,HttpServletResponse response){
        Map<String,Integer> fewerConditionMap = new HashMap<String, Integer>();//用于存放一个属性值有几个
        Map<String,Map<String,Integer>> biggerConditionMap = new HashMap<String, Map<String, Integer>>();//用于存放一个属性


        for (int i = 0; i < goods_ids.length; i++) {
            for (GoodsCondition gc: goodsConditionService.findConditionsByGoods_id(goods_ids[i])
                 ) {
//                两重for循环是为了找到每一条符合条件的筛选属性数据
//


                System.out.println(gc);
                if (!biggerConditionMap.containsKey(gc.getCondition_name())){
//                  如果biggerMap中还没有包含有某个属性：例如品牌
                    fewerConditionMap.put(gc.getCondition_value(),1);
//
                    biggerConditionMap.put(gc.getCondition_name(),fewerConditionMap);
                }
                else {
                    System.out.println(1);
                    if (!biggerConditionMap.get(gc.getCondition_name()).containsKey(gc.getCondition_value())){
                        biggerConditionMap.get(gc.getCondition_name()).put(gc.getCondition_value(),1);
                    }
                    else{
                       Integer a =  biggerConditionMap.get(gc.getCondition_name()).get(gc.getCondition_value());
                       a++;
                       biggerConditionMap.get(gc.getCondition_name()).put(gc.getCondition_value(),a);
                    }
                }

                fewerConditionMap = new HashMap<String, Integer>();
            }
            
        }
        FastJson.toJson(biggerConditionMap,response);

    }

    @RequestMapping(value = "searchByCondition")
    public void searchByCondition(HttpServletResponse response,String conditionName, String conditionValue, GoodsList goodss){
        List<Goods> newGoods = new ArrayList<Goods>();
        for (Goods goods:goodss.getGoodsList()){
            int goodsId = goods.getGoodsId();
            List<GoodsCondition> conditions = goodsConditionService.findConditionsByGoods_id(goodsId);




        }
    }



}
