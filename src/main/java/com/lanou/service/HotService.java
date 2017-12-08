package com.lanou.service;

import com.lanou.entity.Hot;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lanou on 2017/12/7.
 */
public interface HotService {
    public List<String> selectHotName();
    public Hot selectHot(String hotName);
    public int insertHot(String hotName);
    public int updateHotCount(Integer hotCount,String hotName);
    public boolean searchHot(String hotName);
}
