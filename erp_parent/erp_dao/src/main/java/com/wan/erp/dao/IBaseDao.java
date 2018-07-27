package com.wan.erp.dao;

import java.util.List;

public interface IBaseDao <T>{
	
	//条件查询
	public List<T> getList(T t1,T t2,Object param);
	
	//分页条件查询
	public List<T> getListByPage(T t1,T t2,Object param,int firstResult, int maxResults);
	
	//计算条件查询总记录条数
	public long getCount(T t1,T t2,Object param);
	
	//新增
	public void add(T ent);
	
	//删除
	public void delete(Long id);

	//查找编辑
	public T get(Long id);
	public T get(String id);
	
	//更新
	public void update(T ent);
}
