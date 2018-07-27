package com.wan.erp.biz.impl;
import com.wan.erp.biz.IMenuBiz;
import com.wan.erp.dao.IMenuDao;
import com.wan.erp.entity.Menu;
/**
 * 菜单业务逻辑类
 * @author Administrator
 *
 */
public class MenuBiz extends BaseBiz<Menu> implements IMenuBiz {

	private IMenuDao menuDao;
	
	public void setMenuDao(IMenuDao menuDao) {
		this.menuDao = menuDao;
		super.setBaseDao(this.menuDao);
	}
	
}
