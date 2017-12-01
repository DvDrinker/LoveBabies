package com.lanou.controller;

import com.lanou.entity.GoodsCondition;
import com.lanou.service.GoodsConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        model.addAttribute("condition",conditions);
        return "index";
    }

}
