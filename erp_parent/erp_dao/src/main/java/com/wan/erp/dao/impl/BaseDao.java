package com.wan.erp.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wan.erp.dao.IBaseDao;

public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {

	private Class<T> entityClass;
	
	
	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type type=this.getClass().getGenericSuperclass();
		ParameterizedType ptype= (ParameterizedType) type;
		Type[] types = ptype.getActualTypeArguments();
		entityClass=(Class<T>) types[0]; 
	}
	
	//条件查询
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList(T t1,T t2,Object param) {
		DetachedCriteria dc = getDetachedCriteria(t1,t2,param);
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc);
	}
	
	//分页条件查询
	/**
	 * @param t1 条件1
	 * @param t2 条件2
	 * @param param 条件参数
	 * @param firstResault 开始索引
	 * @param maxResults 查询条数
	 * @return 返回实体列表
	 */
	@SuppressWarnings("unchecked")
	public List<T> getListByPage(T t1,T t2,Object param,int firstResult, int maxResults) {
		DetachedCriteria dc = getDetachedCriteria(t1,t2,param);
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc,firstResult, maxResults);
	}
	
	//查询记录条数
	@SuppressWarnings("unchecked")
	@Override
	public long getCount(T t1,T t2,Object param) {
		DetachedCriteria dc = getDetachedCriteria(t1,t2,param);
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>)getHibernateTemplate().findByCriteria(dc);
		return list.get(0);
	}
	
	/**设置条件工具
	 * 由子类实现
	 * @param dep1
	 * @return
	 */
	public DetachedCriteria getDetachedCriteria(T t1,T t2, Object param){
		return null;
	}
	
	//新增
	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
		
	}

	//删除
	@Override
	public void delete(Long id) {
		T res = this.getHibernateTemplate().get(entityClass, id);
		this.getHibernateTemplate().delete(res);
	}

	//查找编辑
	@Override
	public T get(Long id) {
		T res = this.getHibernateTemplate().get(entityClass, id);
		return res;
	}
	
	public T get(String uuid){
		return getHibernateTemplate().get(entityClass, uuid);
	}
	
	//更新
	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
		
	}
}
