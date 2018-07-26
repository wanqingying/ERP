package com.wan.erp.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wan.erp.dao.IDepDao;
import com.wan.erp.entity.Dep;

/**
 * 部门数据访问
 * @author imwan
 *
 */
public class DepDao extends HibernateDaoSupport implements IDepDao {

	/**
	 * 查询所有部门信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> getList() {
		List<Dep>res=(List<Dep>) this.getHibernateTemplate().find("from Dep");
		return res;
	}

}
