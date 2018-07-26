package com.wan.erp.biz.impl;

import java.util.List;

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


	@Override
	public List<Dep> getList() {
		
		return depDao.getList();
	}



}
