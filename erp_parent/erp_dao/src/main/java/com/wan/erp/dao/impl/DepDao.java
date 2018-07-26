package com.wan.erp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wan.erp.dao.IDepDao;
import com.wan.erp.entity.Dep;

/**
 * 部门数据访问
 * @author imwan
 *
 */
public class DepDao extends HibernateDaoSupport implements IDepDao {

	//	查询所有部门信息
	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> getList() {
		List<Dep>res=(List<Dep>) this.getHibernateTemplate().find("from Dep");
		return res;
	}
	//条件查询
	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> getList(Dep dep1, int startind, int rows) {
		
		DetachedCriteria dc=getdtc(dep1);
		List<Dep> res=(List<Dep>) this.getHibernateTemplate().findByCriteria(dc,startind,rows);
		return res;
	}
	
	//查询记录条数
	@SuppressWarnings("unchecked")
	@Override
	public int countall(Dep dep1) {
		DetachedCriteria dc = getdtc(dep1);
		dc.setProjection(Projections.rowCount());
		List<Long> res = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		return res.get(0).intValue();
	}
	
	//设置条件工具
	private DetachedCriteria getdtc(Dep dep1){
		DetachedCriteria dc=DetachedCriteria.forClass(Dep.class);
		if(null != dep1){
			if(null != dep1.getName() && dep1.getName().trim().length()>0){
				dc.add(Restrictions.like("name", dep1.getName(), MatchMode.ANYWHERE));
			}
			if(null != dep1.getTele() && dep1.getTele().trim().length()>0){
				dc.add(Restrictions.like("tele", dep1.getTele(), MatchMode.ANYWHERE));
			}
		}
		return dc;
	}
	
	//新增部门
	@Override
	public void save(Dep dep) {
		this.getHibernateTemplate().save(dep);
		
	}

	//删除部门
	@Override
	public void delete(Long uuid) {
		Dep res = this.getHibernateTemplate().get(Dep.class, uuid);
		this.getHibernateTemplate().delete(res);
	}
	
	//查找部门编辑
	@Override
	public Dep get(Long uuid) {
		return this.getHibernateTemplate().get(Dep.class, uuid);
	}
	
	//更新部门
	@Override
	public void update(Dep dep) {
		this.getHibernateTemplate().update(dep);
		
	}
	
	
	
	
}
