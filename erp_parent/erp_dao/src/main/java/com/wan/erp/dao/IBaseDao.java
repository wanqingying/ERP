package com.wan.erp.dao;

import java.util.List;

public interface IBaseDao <T>{
	
	//条件查询
	public List<T> getList(T ent, int startind, int rows);

	//计算条件查询总记录条数
	public int countall(T ent);
	
	//新增
	public void save(T ent);
	
	//删除
	public void delete(Long id);

	//查找编辑
	public T get(Long id);
	
	//更新
	public void update(T ent);
}
