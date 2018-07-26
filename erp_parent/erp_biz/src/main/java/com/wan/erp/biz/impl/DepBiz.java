package com.wan.erp.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wan.erp.biz.IDepBiz;
import com.wan.erp.dao.IDepDao;
import com.wan.erp.entity.Dep;

/**
 * 部门业务实现
 * @author imwan
 *
 */
public class DepBiz implements IDepBiz {
	
	/*
	 * 注入数据访问对象
	 */
	private IDepDao depDao;
	 

	public void setDepDao(IDepDao depDao) {
		this.depDao = depDao;
	}

	//查询所有部门
	@Override
	public List<Dep> getList() {
		
		return depDao.getList();
	}

	//带条件分页查询部门
	@Override
	public Map<String, Object> getList(Dep dep1, int startind, int rows,Dep dep2 ,Object param) {
		Map<String, Object> data=new HashMap<>();
		int total=depDao.countall(dep1);
		List<Dep> list = depDao.getList(dep1, startind, rows);
		data.put("rows", list);
		data.put("total", total);
		return data;
	}

	//新增部门
	@Override
	public void save(Dep dep) {
		depDao.save(dep);
		
	}

	//删除部门
	@Override
	public void delete(Long uuid) {
		depDao.delete(uuid);
		
	}

	//查找部门编辑
	@Override
	public Dep get(Long uuid) {
		return depDao.get(uuid);
	}

	@Override
	public void update(Dep dep) {
		depDao.update(dep);
		
	}
	
	


}
