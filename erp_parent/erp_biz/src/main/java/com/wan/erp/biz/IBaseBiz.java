package com.wan.erp.biz;

import java.util.List;

/**
 * 通用业务接口
 * @author imwan
 *
 */
public interface IBaseBiz <T> {
	
	//条件查询
	List<T> getList(T t1,T t2,Object param);
	
	//分页条件查询
	List<T> getListByPage(T t1,T t2,Object param,int firstResult, int maxResults);
	
	//计算总记录数
	public long getCount(T t1,T t2,Object param);
	
	//新增
	public void add(T t);
	
	//删除
	public void delete(Long id);

	//查找
	T get(Long id);
	T get(String id);

	//更新
	void update(T t);
}
