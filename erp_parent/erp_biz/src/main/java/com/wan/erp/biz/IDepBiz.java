package com.wan.erp.biz;

import java.util.List;
import java.util.Map;

import com.wan.erp.entity.Dep;

/**
 * 部门业务接口
 * @author imwan
 *
 */
public interface IDepBiz {
	
	 //查询所有部门列表
	List<Dep> getList();
	
	//	条件查询：属性驱动
	Map<String, Object> getList(Dep dep1, int startind, int rows, Dep dep2, Object param);
	
	//新增部门
	public void save(Dep dep);
	
	//删除部门
	public void delete(Long uuid);

	//查找部门编辑
	Dep get(Long uuid);

	//更新部门
	void update(Dep dep);
}
