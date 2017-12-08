package com.lanou.service.impl;

import com.lanou.dao.HotMapper;
import com.lanou.entity.Hot;
import com.lanou.service.HotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/7.
 */
@Service("hotService")
public class HotServiceImpl implements HotService{
    @Autowired
    private HotMapper hotMapper;

    public List<String> selectHotName() {
        List<String> hotNames=hotMapper.selectHotName();
        return hotNames;
    }

    public Hot selectHot(String hotName) {
        Hot hot=hotMapper.selectHot(hotName);
        return hot;
    }

    public int insertHot(String hotName) {
        int result=hotMapper.insertHot(hotName);
        return result;
    }

    public int updateHotCount(Integer hotCount, String hotName) {
        Hot hot=selectHot(hotName);
        int result=hotMapper.updateHotCount(hot.getCount()+1,hotName);
        return result;
    }

    public boolean searchHot(String hotName){
        boolean result=false;
        Hot hot=selectHot(hotName);
        if (hot==null){
            int insertNum=insertHot(hotName);
            if (insertNum==1){
                result=true;
            }
        }else{
            int updateNum=updateHotCount(hot.getCount()+1,hotName);
            if (updateNum==1){
                result=true;
            }
        }
        return result;
    }


}
