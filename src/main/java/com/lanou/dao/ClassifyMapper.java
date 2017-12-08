package com.lanou.dao;

import com.lanou.entity.Classify;

import java.util.List;

public interface ClassifyMapper {
	public List<Classify> findFirstClassify(Integer classifyParentId);
	public Classify findById(Integer classifyId);
	public Classify findSimpleById(Integer classifyId);
	public List<Classify> findChildById(Integer classifyId);
	public List<Classify> findByParentId();
	public Classify findClassifyByParentId(Integer classifyParentId);


}
