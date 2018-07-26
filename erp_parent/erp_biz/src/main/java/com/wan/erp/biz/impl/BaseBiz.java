package com.wan.erp.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.wan.erp.biz.IBaseBiz;
import com.wan.erp.dao.IBaseDao;
public class BaseBiz<T> implements IBaseBiz<T> {
	/*
	 * 注入数据访问对象
	 */
	@SuppressWarnings("rawtypes")
	private IBaseDao baseDao;
	 
	

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
	public void setTDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	//带条件分页查询
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getList(T ent1, int startind, int rows,T ent2 ,Object param) {
		Map<String, Object> data=new HashMap<>();
		int total=baseDao.countall(ent1);
		List<T> list = baseDao.getList(ent1, startind, rows);
		data.put("rows", list);
		data.put("total", total);
		return data;
	}

	//新增部门
	@SuppressWarnings("unchecked")
	@Override
	public void save(T t) {
		baseDao.save(t);
		
	}

	//删除部门
	@Override
	public void delete(Long id) {
		baseDao.delete(id);
		
	}

	//查找部门编辑
	@SuppressWarnings("unchecked")
	@Override
	public T get(Long id) {
		return (T) baseDao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(T ent) {
		baseDao.update(ent);
		
	}
}
