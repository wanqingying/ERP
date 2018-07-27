package com.wan.erp.web.action;
import com.wan.erp.biz.IRoleBiz;
import com.wan.erp.entity.Role;

/**
 * 角色Action 
 * @author Administrator
 *
 */
public class RoleAction extends BaseAction<Role> {

	private IRoleBiz roleBiz;

	public void setRoleBiz(IRoleBiz roleBiz) {
		this.roleBiz = roleBiz;
		super.setBaseBiz(this.roleBiz);
	}

}
