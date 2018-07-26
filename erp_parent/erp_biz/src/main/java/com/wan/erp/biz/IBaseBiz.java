package com.wan.erp.biz;

import java.util.List;
import java.util.Map;

/**
 * 通用业务接口
 * @author imwan
 *
 */
public interface IBaseBiz <T> {
	
	//	条件查询：属性驱动
	Map<String, Object> getList(T ent, int startind, int rows, T ent2, Object param);
	
	//新增
	public void save(T t);
	
	//删除
	public void delete(Long id);

	//查找编辑
	T get(Long id);

	//更新
	void update(T ent);
}
