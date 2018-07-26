package com.wan.erp.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wan.erp.biz.IDepBiz;
import com.wan.erp.biz.impl.BaseBiz;
import com.wan.erp.entity.Dep;

/**
 * 部门Action
 * @author imwan
 *
 */
public class DepAction extends BaseAction<Dep> {
	
	//	注入服务
	private IDepBiz depBiz;
	private Dep dep;
	private Dep dep1;
	private Dep dep2;
	private int page;
	private int rows;
	private Object param;
	private Long uuid;

	public void setUuid(Long uuid) {
		this.uuid = uuid;
		super.setUuid(this.uuid);
	}

	public void setDepBiz(IDepBiz depBiz) {
		this.depBiz = depBiz;
		super.setBaseBiz(this.depBiz);
		super.setBaseprefix("dep.");
	}

	public void setDep(Dep dep) {
		this.dep = dep;
		super.setT(this.dep);
	}
	public Dep getDep() {
		return dep;
	}

	public void setDep1(Dep dep1) {
		this.dep1 = dep1;
		super.setT1(this.dep1);
	}
	
	public Dep getDep1() {
		return dep1;
	}

	public void setDep2(Dep dep2) {
		this.dep2 = dep2;
		super.setT2(this.dep2);
	}

	public Dep getDep2() {
		return dep2;
	}

	public void setPage(int page) {
		this.page = page;
		super.setPage(this.page);
	}

	public void setRows(int rows) {
		this.rows = rows;
		super.setRows(this.rows);
	}

	public void setParam(Object param) {
		this.param = param;
		super.setParam(this.param);
	}
	
	
	
	
}
