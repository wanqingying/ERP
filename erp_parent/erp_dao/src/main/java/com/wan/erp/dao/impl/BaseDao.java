package com.wan.erp.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.wan.erp.dao.IBaseDao;

public class BaseDao <T> extends HibernateDaoSupport implements IBaseDao<T> {

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
	public List<T> getList(T t1, int startind, int rows) {
		
		DetachedCriteria dc=getdtc(t1);
		List<T> res=(List<T>) this.getHibernateTemplate().findByCriteria(dc,startind,rows);
		return res;
	}
	
	//查询记录条数
	@SuppressWarnings("unchecked")
	@Override
	public int countall(T t1) {
		DetachedCriteria dc = getdtc(t1);
		dc.setProjection(Projections.rowCount());
		List<Long> res = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		return res.get(0).intValue();
	}
	
	/**设置条件工具
	 * 由子类实现
	 * @param dep1
	 * @return
	 */
	public DetachedCriteria getdtc(T ent){
		return null;
	}
	
	//新增
	@Override
	public void save(T t) {
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
		return this.getHibernateTemplate().get(entityClass, id);
	}
	
	//更新
	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
		
	}
}
