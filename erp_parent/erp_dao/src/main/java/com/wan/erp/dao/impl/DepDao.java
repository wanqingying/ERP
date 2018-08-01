package com.wan.erp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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
	
	public DetachedCriteria getDetachedCriteria(Dep dep1,Dep dep2,Object param){
		DetachedCriteria dc=DetachedCriteria.forClass(Dep.class);
		if(dep1!=null){
			if(null != dep1.getName() && dep1.getName().trim().length()>0){
				dc.add(Restrictions.like("name", dep1.getName(), MatchMode.ANYWHERE));
			}
			if(null != dep1.getTele() && dep1.getTele().trim().length()>0){
				dc.add(Restrictions.like("tele", dep1.getTele(), MatchMode.ANYWHERE));
			}

		}
		return dc;
	}
	
	
}
