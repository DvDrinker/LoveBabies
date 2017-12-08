package com.lanou.dao;

import com.lanou.entity.Hot;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lanou on 2017/12/7.
 */
public interface HotMapper {

    public List<String> selectHotName();
    public Hot selectHot(@Param("hotName")String hotName);
    public int insertHot(@Param("hotName")String hotName);
    public int updateHotCount(@Param("hotCount")Integer hotCount,@Param("hotName")String hotName);

}
