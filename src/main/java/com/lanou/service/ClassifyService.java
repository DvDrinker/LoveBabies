package com.lanou.service;

import com.lanou.entity.Classify;
import com.lanou.entity.Teacher;

import java.util.List;

public interface ClassifyService {

	public List<Classify> findFirstClassify(Integer classifyParentId);
	public Classify findById(Integer classifyId);
	public List<Classify> findChildById(Integer classifyId);
	public List<Integer> findAllThirdId(Integer classifyId);
	
}
