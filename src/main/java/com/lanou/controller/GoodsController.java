package com.lanou.controller;

import com.lanou.entity.*;
import com.lanou.service.ClassifyService;
import com.lanou.service.GoodsConditionService;
import com.lanou.service.GoodsService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                                     Integer sequence,//顺序参数
                                     Double maxPrice,//价格区间最大值
                                     Double minPrice//价格区间最小值
    ){
        if (keyword == null){//针对keyword为空的情况
            keyword = "";
        }


        List<Integer> classifyIds = classifyService.findAllThirdId(classifyId);//根据classifyId得到所有的三级分类
        System.out.println("sequence:"+sequence);
        List<Goods> goodsList = goodsService.findGoodsByOneClassifyId(classifyIds);
        //1.根据得到的三级分类Id集合查询出所有的商品信息
        List<Goods> goodsList1 = new ArrayList<Goods>();
        System.out.println(goodsList1.size());
        if (goodsList.size()>0){//
            goodsList1 = goodsService.findLikeKeyword(keyword,goodsList);
            //2.根据上一步操作得到的list，取出其中符合模糊查询的部分
            System.out.println("smqsmq");
            System.out.println("conditions:"+conditions.getGoodsConditionList());
        }




//        List<Integer> goodsList1Id = new ArrayList<Integer>();
//
//        for (Goods goods:
//             goodsList1) {
//            goodsList1Id.add(goods.getGoodsId());
//
//        }

        //3.此处是为了从标签条件中筛选
        if (goodsList1.size()>0){

            if(conditions.getGoodsConditionList() != null){//针对Condition参数为空的情况

                for (GoodsCondition condition:conditions.getGoodsConditionList()
                        ) {
                    goodsList1 = goodsConditionService.getGoodsIdByCondition(condition,goodsList1);
                }
            }
        }




        if (maxPrice == null){//针对maxPrice与minPrice为空的情况，默认为0-10000
            maxPrice = 10000.0;
        }
        if (minPrice == null){
            minPrice = 0.0;
        }

        if (goodsList1.size()>0){
            //4.此处针对最大最小价格筛选
            goodsList1 = goodsService.findGoodsByPrice(maxPrice,minPrice,goodsList1);
        }



//        //此处构造商品的左侧分类表
//        List<Classify> classifies= classifyService.findChildById(classifyId);//左侧分类表
        Map<String,Map<String,Integer>> biggerConditionMap = new HashMap<String, Map<String, Integer>>();//用于存放一个属性
        if (goodsList1.size()>0){
            Integer[] goods_ids = new Integer[goodsList1.size()];
            for (int i = 0; i <goods_ids.length ; i++) {
                goods_ids[i] = goodsList1.get(i).getGoodsId();
            }

            Map<String,Integer> fewerConditionMap = new HashMap<String, Integer>();//用于存放一个属性值有几个



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
        }












        //5.此处统计所有符合条件的商品的个数
        Integer GoodsNum = goodsList1.size();


        if (sequence == null){//针对sequence参数为空的情况，默认为1
            sequence = 1;
        }
        //6.此处对筛选出的商品进行以sequence为参数的排序
        if (goodsList1.size()>0){
            goodsList1 = goodsService.findGoodsBySequence(sequence,goodsList1);
        }



        if (page == null || page<=0){//针对page参数为空的情况，默认为第一页
            page = 1;
        }
        CutPage cutPage = new CutPage();
        //7.此处对筛选出的商品进行分页，只留需要页的部分
        if (goodsList1.size()>0){

            cutPage.setPage(page);
            int totalPage  =  goodsList1.size()%cutPage.COUNT == 0
                    ? goodsList1.size()/cutPage.COUNT
                    : goodsList1.size()/cutPage.COUNT + 1 ;



            cutPage.setTotalPage(totalPage);
            System.out.println(cutPage);
            goodsList1 = goodsService.limitGoods(cutPage,goodsList1);
        }












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

//      需要放到map中的对象有商品集合,分页对象,筛选表,商品总个数,

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("goodsList",goodsList1);
        resultMap.put("cutPage",cutPage);
        resultMap.put("conditions",biggerConditionMap);
        resultMap.put("goodsSize",GoodsNum);
//        resultMap.put("classifies",classifies);
        FastJson.toJson(resultMap,response);
    }




}
