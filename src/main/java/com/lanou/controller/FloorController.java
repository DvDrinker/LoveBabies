package com.lanou.controller;

import com.lanou.entity.Floor;
import com.lanou.service.FloorService;
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
@RequestMapping("/floor")
public class FloorController {
    @Autowired
    private FloorService floorService;
    @RequestMapping("/findAllFloor.do")
    public void findAllFloor(HttpServletResponse response){
        List<Floor> floors=floorService.findAllFloor();
        FastJson.toJson(floors,response);
    }


}
