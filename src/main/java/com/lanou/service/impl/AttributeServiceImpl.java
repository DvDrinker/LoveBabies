package com.lanou.service.impl;

import com.lanou.dao.AttributeMapper;
import com.lanou.entity.Attribute;
import com.lanou.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/12.
 */
@Service("attributeService")
public class AttributeServiceImpl implements AttributeService{
    @Autowired
    private AttributeMapper attributeMapper;

    public List<Attribute> findAttribute(Integer userId) {
        return attributeMapper.findAttribute(userId);
    }

    public void insertAttribute(Attribute attribute) {
        attributeMapper.addAttribute(attribute);
    }

    public void deleteAttribute(Integer aId) {
        attributeMapper.deleteAttribute(aId);
    }
}
