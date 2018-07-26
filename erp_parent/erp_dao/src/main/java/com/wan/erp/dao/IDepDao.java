package com.wan.erp.dao;

import java.util.List;

import com.wan.erp.entity.Dep;

public interface IDepDao {
	
	public List<Dep> getList();
	
	public List<Dep> getList(Dep dep1);
	
	
}
