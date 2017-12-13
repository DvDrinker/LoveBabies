package com.lanou.controller;

import com.lanou.entity.Attribute;
import com.lanou.entity.User;
import com.lanou.service.AttributeService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lanou on 2017/12/12.
 */
@Controller
@RequestMapping("/attribute")
public class AttributeController {
    @Autowired
    private AttributeService attributeService;

    @RequestMapping("/findAttribute.do")
    public void findAttribute(HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        if (user == null){
            FastJson.toJson("noLogin",response);
        }
        else {
            List<Attribute> attributes = attributeService.findAttribute(user.getUserId());
            FastJson.toJson(attributes,response);
        }

    }

    @RequestMapping("/insertAttribute.do")
    public void insertAttribute(Integer goodsId,HttpServletResponse response,HttpServletRequest request){
        Attribute attribute = new Attribute();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            String jsonStr = "noLogin";
            FastJson.toJson(jsonStr,response);
        }
        else {
            attribute.setGoodsId(goodsId);
            attribute.setUserId(user.getUserId());
            attributeService.insertAttribute(attribute);
            String jsonStr = "insertSuccess";
            FastJson.toJson(jsonStr,response);
        }
    }
//    单个删除
    @RequestMapping("/deleteAttribute.do")
    public void deleteAttribute(Integer aId,HttpServletResponse response){
        attributeService.deleteAttribute(aId);
        FastJson.toJson("deleteSucess",response);
    }
//  批量删除
    @RequestMapping("/deleteAttributeList.do")
    public void deleteAttributeList(Integer[] aIds,HttpServletResponse response){
        attributeService.deleteAttributeList(aIds);
        FastJson.toJson("deleteSuccess",response);

    }
}
