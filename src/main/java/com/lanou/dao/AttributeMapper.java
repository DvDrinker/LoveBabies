package com.lanou.dao;

import com.lanou.entity.Attribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lanou on 2017/12/12.
 */
public interface AttributeMapper {
    public List<Attribute> findAttribute(@Param("userId") Integer userId);

    public void addAttribute(@Param("attribute") Attribute attribute);

    public void deleteAttribute(@Param("aId") Integer aId);

}
