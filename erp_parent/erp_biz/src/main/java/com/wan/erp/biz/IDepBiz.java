package com.wan.erp.biz;

import java.util.List;

import com.wan.erp.entity.Dep;

/**
 * 部门业务接口
 * @author imwan
 *
 */
public interface IDepBiz {
	/**
	 * 查询所有部门列表
	 */
	List<Dep> getList();
	
}
