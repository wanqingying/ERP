package com.wan.erp.web.action;

import com.wan.erp.biz.IDepBiz;
import com.wan.erp.entity.Dep;
/**
 * 部门Action
 * @author imwan
 *
 */
public class DepAction extends BaseAction<Dep> {
	
	private IDepBiz depBiz;
	private Dep dep;

	public void setDepBiz(IDepBiz depBiz) {
		this.depBiz = depBiz;
		super.setBaseBiz(this.depBiz);
	}

	public void setDep(Dep dep) {
		this.dep = dep;
		super.setT(this.dep);
	}

	public Dep getDep() {
		return dep;
	}
	

	
	
}
