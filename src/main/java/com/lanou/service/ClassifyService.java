package com.lanou.service;

import com.lanou.entity.Classify;

import java.util.List;

public interface ClassifyService {

	public List<Classify> findFirstClassify(Integer classifyParentId);
	public Classify findById(Integer classifyId);
	public Classify findSimpleById(Integer classifyId);
	public List<Classify> findChildById(Integer classifyId);
	public List<Integer> findAllThirdId(Integer classifyId);
	public List<Classify> findAllThirdName(Integer classifyId);
	public List<Integer> findByParentId();
	public List<String> findByThirdId(Integer classifyId);
	
}
