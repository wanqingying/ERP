package com.wan.erp.biz;

import java.util.List;
import java.util.Map;

import com.wan.erp.entity.Dep;

/**
 * 部门业务接口
 * @author imwan
 *
 */
@SuppressWarnings("rawtypes")
public interface IDepBiz extends IBaseBiz<Dep> {
	
	 //查询所有部门列表
	List<Dep> getList();
}
