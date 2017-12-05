package com.lanou.service.impl;

import com.lanou.dao.CitysMapper;
import com.lanou.entity.Citys;
import com.lanou.entity.User;
import com.lanou.service.CitysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
@Service("citysService")
public class CitysServiceImpl implements CitysService {
    @Autowired
    private CitysMapper citysMapper;

    public List<Citys> selectCitys(Integer parentId) {
        List<Citys> citys = citysMapper.selectCitys(parentId);
        return citys;
    }

}
