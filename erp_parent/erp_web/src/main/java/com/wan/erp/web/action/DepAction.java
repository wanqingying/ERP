package com.wan.erp.web.action;

import java.io.IOException;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.alibaba.fastjson.JSON;
import com.wan.erp.biz.IDepBiz;
import com.wan.erp.entity.Dep;

/**
 * 部门Action
 * @author imwan
 *
 */
public class DepAction {
	
	private IDepBiz depBiz;

	public void setDepBiz(IDepBiz depBiz) {
		this.depBiz = depBiz;
	}
	
	public String list(){
		System.out.println("ok");
		List<Dep> list=depBiz.getList();
		String listString = JSON.toJSONString(list);
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf8");
			ServletActionContext.getResponse().getWriter().write(listString);
		} catch (IOException e) {
			System.out.println("exception:com.wan.erp.web.action.DepAction");
			e.printStackTrace();
		}
		return null;
		
	}
}
