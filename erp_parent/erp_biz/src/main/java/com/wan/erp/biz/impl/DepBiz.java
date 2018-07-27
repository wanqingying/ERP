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
public class DepBiz extends BaseBiz<Dep> implements IDepBiz {
	
	
	//注入数据访问对象
	private IDepDao depDao;
	
	public void setDepDao(IDepDao depDao) {
		this.depDao = depDao;
		super.setBaseDao(this.depDao);
	}
	

}
