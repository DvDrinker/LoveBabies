package com.lanou.controller;

import com.lanou.entity.Brand;
import com.lanou.entity.Classify;
import com.lanou.entity.Goods;
import com.lanou.service.BrandService;
import com.lanou.service.ClassifyService;
import com.lanou.service.GoodsService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by lanou on 2017/12/5.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private BrandService brandService;
    @RequestMapping("/index.do")
    public void index(Integer classifyId, HttpServletResponse response){
        Map<String,Object> maps=new HashMap<String, Object>();
        List<Integer> thirdIdList=classifyService.findAllThirdId(classifyId);
        //System.out.println("thirdIdList:"+thirdIdList);
        List<Integer> goodsId=goodsService.findGoodsIdByThirdId(thirdIdList);
       // System.out.println("goodsId:"+goodsId);
        Set<Integer> goodsIds=new HashSet<Integer>();
        Random random=new Random();
        while (goodsIds.size()!=7){
            int id=random.nextInt(goodsId.size());
            goodsIds.add(goodsId.get(id));
        }
        System.out.println("goodsId集合："+goodsIds);
        List<Goods> goods=goodsService.findGoodsByIdSet(goodsIds);
        System.out.println("goods:"+goods);
        List<Classify> thirdNameList=classifyService.findAllThirdName(classifyId);
        System.out.println("thirdNameList:"+thirdNameList);
        List<Brand> brands=brandService.findBrandByClassifyId(classifyId);
        System.out.println("brands:"+brands);
        maps.put("goods",goods);
        maps.put("thirdNameList",thirdNameList);
        maps.put("brands",brands);
        FastJson.toJson(maps,response);
    }



}
