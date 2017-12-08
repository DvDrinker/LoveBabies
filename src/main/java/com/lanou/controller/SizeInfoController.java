package com.lanou.controller;

import com.lanou.entity.SizeInfo;
import com.lanou.service.SizeInfoService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanou on 2017/12/8.
 */
@Controller
@RequestMapping("/sizeInfo")
public class SizeInfoController {
    @Autowired
    private SizeInfoService sizeInfoService;
    @RequestMapping("/findSizeInfoByGoodsId")
    public void findSizeInfoByGoodsId(HttpServletResponse response,Integer goodsId){
        List<SizeInfo> sizes = sizeInfoService.findSizeInfoByGoodsId(goodsId);
        FastJson.toJson(sizes,response);
    }
}
