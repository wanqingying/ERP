package com.wan.erp.dao;

import java.util.List;

import com.wan.erp.entity.Dep;

public interface IDepDao {
	
	//查询所有
	public List<Dep> getList();
	
	//条件查询
	public List<Dep> getList(Dep dep1, int startind, int rows);

	//计算条件查询总记录条数
	public int countall(Dep dep1);
	
	//新增部门
	public void save(Dep dep);
	
	//删除部门
	public void delete(Long uuid);

	//查找部门编辑
	public Dep get(Long uuid);
	
	//更新部门
	public void update(Dep dep);
}
