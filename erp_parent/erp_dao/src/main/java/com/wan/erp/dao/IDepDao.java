package com.wan.erp.dao;

import java.util.List;

import com.wan.erp.entity.Dep;
/**
 * 部门数据持久对象接口
 * @author imwan
 *
 */
public interface IDepDao extends IBaseDao<Dep> {
	
	public List<Dep> getList();
}
