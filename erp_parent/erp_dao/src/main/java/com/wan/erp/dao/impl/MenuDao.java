package com.wan.erp.dao.impl;
import org.hibernate.criterion.DetachedCriteria;

import com.wan.erp.dao.IMenuDao;
import com.wan.erp.entity.Menu;
/**
 * 菜单数据访问类
 * @author Administrator
 *
 */
public class MenuDao extends BaseDao<Menu> implements IMenuDao {

	/**
	 * 构建查询条件
	 * @param dep1
	 * @param dep2
	 * @param param
	 * @return
	 */
	public DetachedCriteria getDetachedCriteria(Menu menu1,Menu menu2,Object param){
		DetachedCriteria dc=DetachedCriteria.forClass(Menu.class);
		return dc;
	}

}
