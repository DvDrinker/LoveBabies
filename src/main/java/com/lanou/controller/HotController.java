package com.lanou.controller;

import com.lanou.service.HotService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanou on 2017/12/7.
 */
@Controller
@RequestMapping("/hot")
public class HotController {
    @Autowired
    private HotService hotService;
    @RequestMapping("/selectHotName.do")
    public void selectHotName(HttpServletResponse response){
        List<String> hotNames=hotService.selectHotName();
        FastJson.toJson(hotNames,response);
    }

}
