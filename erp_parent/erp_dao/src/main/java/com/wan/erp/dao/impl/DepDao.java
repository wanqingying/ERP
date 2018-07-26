package com.wan.erp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
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
	public List<Dep> getList(Dep dep1) {
		
		DetachedCriteria dc=DetachedCriteria.forClass(Dep.class);
		System.out.println(dep1);
		if(null != dep1){
			if(null != dep1.getName() && dep1.getName().trim().length()>0){
				dc.add(Restrictions.like("name", dep1.getName(), MatchMode.ANYWHERE));
			}
			if(null != dep1.getTele() && dep1.getTele().trim().length()>0){
				dc.add(Restrictions.like("name", dep1.getTele(), MatchMode.ANYWHERE));
			}
		}
		List<Dep> res=(List<Dep>) this.getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);
		dc.setTimeout(1);
		return res;
	}

}
