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
	
	private IDepBiz depBiz;

	public void setDepBiz(IDepBiz depBiz) {
		this.depBiz = depBiz;
		super.setBaseBiz(this.depBiz);
	}

	
	
}
