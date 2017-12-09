package com.lanou.controller;

import com.lanou.entity.*;
import com.lanou.service.ClassifyService;
import com.lanou.service.GoodsConditionService;
import com.lanou.service.GoodsService;
import com.lanou.service.HotService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    private HotService hotService;

    @RequestMapping("/findGoodsOrderBy.do")
    public void findGoodsOrderBy(@RequestParam(required = true,defaultValue = "1") Integer orderBy, HttpServletResponse response){
        List<Goods> goodss=goodsService.findGoodsOrderBy(orderBy);
        FastJson.toJson(goodss,response);
    }

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
        List<Integer> classifyIds;
        if (classifyId == null || classifyId == 0){
            classifyIds = classifyService.findByParentId();
        }
        else {
            classifyIds = classifyService.findAllThirdId(classifyId);//根据classifyId得到所有的三级分类
        }

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
            if (keyword==null||keyword.equals("")){
            }else{
                hotService.searchHot(keyword);
            }
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


//此处构造商品的左侧分类表
        List<Classify> classifies= classifyService.findChildById(classifyId);//左侧分类表
        //请求商品分类数量数据
        Map<String ,Integer> classifyMap = new HashMap<String, Integer>();
        for (Goods goods: goodsList1
                ) {
            String a ;
            a = goods.getGoodsThirdClassifyId().toString();
            if (classifyMap.containsKey(a)){
                classifyMap.put(a,classifyMap.get(a)+1);
            }else {
                classifyMap.put(a,1);
            }

        }


        long programTime1 = System.currentTimeMillis();
        List<Map<String,Object>> condist = new ArrayList<Map<String,Object>>();

        if (goodsList1.size()>0){
            for (Goods goods:goodsList1){
                Integer goodsId1 = goods.getGoodsId();
                List<GoodsCondition> goodsConditions = goodsConditionService.findConditionsByGoods_id(goodsId1);
                for (GoodsCondition goodsCondition: goodsConditions
                        ) {
                    int aaa = 0;
                    for (int i = 0;i < condist.size();i++){

                        if(condist.get(i).get("condition_name").equals(goodsCondition.getCondition_name())){
                            aaa = 1;
                            List newList = (List) condist.get(i).get("condition_info");
                            int bbb = 0;
                            for (int j = 0;j < newList.size();j++){
                                Map maps = new HashMap();
                                maps = (Map) newList.get(j);
                                if(maps.get("condition_value").equals(goodsCondition.getCondition_value())){
                                    Integer a = (Integer) maps.get("condition_num");
                                    maps.put("condition_num",a+1);
                                    bbb=1;

                                }
                            }
                            if (bbb == 0){
                                Map maps = new HashMap();
                                maps.put("condition_value",goodsCondition.getCondition_value());
                                maps.put("condition_num",1);

                                newList.add(maps);
                            }



                        }

                    }
                    if (aaa == 0){
                        Map<String,Object> biggerConditionMap = new HashMap<String,Object>();//用于存放品牌与列表

                        biggerConditionMap.put("condition_name",goodsCondition.getCondition_name());
                        List lists = new ArrayList();
                        biggerConditionMap.put("condition_info",lists);
                        Map maps = new HashMap();
                        maps.put("condition_value",goodsCondition.getCondition_value());
                        maps.put("condition_num",1);
                        lists.add(maps);
                        condist.add(biggerConditionMap);
                    }


//                    for (Map<String,Object> objectMap: condist
//                         ) {
//                        a=1;
//                        if (objectMap.get("name").equals(goodsCondition.getCondition_name())){
//                            Map<String,Integer> fewerConditionMap = (Map<String, Integer>) objectMap.get("condition");
//                            if (fewerConditionMap.containsKey(goodsCondition.getCondition_value())){
//                                fewerConditionMap.put(goodsCondition.getCondition_value(),
//                                fewerConditionMap.get(goodsCondition.getCondition_value())+1);
//                                //++
//                                break;
//                            }
//                            else {
//                                fewerConditionMap.put(goodsCondition.getCondition_value(),
//                                1);
//                                break;
//                            }
//
//                        }
//
//
//                    }
//                if (a == 0){
//                    Map<String,Integer> fewerConditionMap = new HashMap<String, Integer>();
//                    fewerConditionMap.put(condition)
//                    fewerConditionMap.put(goodsCondition.getCondition_value(),1);
//                    biggerConditionMap.put("name",goodsCondition.getCondition_name());
//
//                    condist.add();
//                }

                }
            }
        }

        long time2 = System.currentTimeMillis();
        System.out.println("筛选分类运行时间："+(time2-programTime1));










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
            cutPage.setCOUNT(12);
            cutPage.setPage(page);
            int totalPage  =  goodsList1.size()%cutPage.getCOUNT() == 0
                    ? goodsList1.size()/cutPage.getCOUNT()
                    : goodsList1.size()/cutPage.getCOUNT() + 1 ;



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
        resultMap.put("conditions",condist);
        resultMap.put("goodsSize",GoodsNum);
        resultMap.put("ClassifyCount",classifyMap);
//        resultMap.put("classifies",classifies);
        FastJson.toJson(resultMap,response);
    }



    public void findGoodsByGoodsId(){

    }

}
