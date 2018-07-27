package com.wan.erp.biz.impl;
import com.wan.erp.biz.IRoleBiz;
import com.wan.erp.dao.IRoleDao;
import com.wan.erp.entity.Role;
/**
 * 角色业务逻辑类
 * @author Administrator
 *
 */
public class RoleBiz extends BaseBiz<Role> implements IRoleBiz {

	private IRoleDao roleDao;
	
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
		super.setBaseDao(this.roleDao);
	}
	
}
