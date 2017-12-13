package com.lanou.service;

import com.lanou.entity.Attribute;

import java.util.List;

/**
 * Created by lanou on 2017/12/12.
 */

public interface AttributeService {
    public List<Attribute> findAttribute(Integer userId);

    public void insertAttribute(Attribute attribute);

    public void deleteAttribute(Integer aId);

    public void deleteAttributeList(Integer[] aIds);

}
