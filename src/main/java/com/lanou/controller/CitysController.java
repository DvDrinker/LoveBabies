package com.lanou.controller;

import com.lanou.entity.Citys;
import com.lanou.service.CitysService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
@Controller
@RequestMapping("/citys")
public class CitysController {
    @Autowired
    private CitysService citysService;
    @RequestMapping( value = "/select.do")
    public void selectCitys(Integer parentId, HttpServletResponse response){
        List<Citys> citys = citysService.selectCitys(parentId);
        FastJson.toJson(citys,response);
    }
}
