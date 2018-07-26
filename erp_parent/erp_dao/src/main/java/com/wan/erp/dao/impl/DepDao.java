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
public class DepDao extends BaseDao<Dep> implements IDepDao {

	//	查询所有部门信息
	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> getList() {
		List<Dep>res=(List<Dep>) this.getHibernateTemplate().find("from Dep");
		return res;
	}
	
	
	//设置条件工具
	
	@SuppressWarnings("unused")
	public DetachedCriteria getdtc(Dep ent){
		DetachedCriteria dc=DetachedCriteria.forClass(Dep.class);
		if(null != ent){
			if(null != ent.getName() && ent.getName().trim().length()>0){
				dc.add(Restrictions.like("name", ent.getName(), MatchMode.ANYWHERE));
			}
			if(null != ent.getTele() && ent.getTele().trim().length()>0){
				dc.add(Restrictions.like("tele", ent.getTele(), MatchMode.ANYWHERE));
			}
		}
		return dc;
	}
	
	
}
