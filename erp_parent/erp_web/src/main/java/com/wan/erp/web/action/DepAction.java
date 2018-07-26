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
	
	//	注入服务
	private IDepBiz depBiz;

	public void setDepBiz(IDepBiz depBiz) {
		this.depBiz = depBiz;
	}
	
	//条件查询模型
	private Dep dep1; 
	
	
	public Dep getDep1() {
		return dep1;
	}

	public void setDep1(Dep dep1) {
		this.dep1 = dep1;
	}

	//查询所有
	public void list(){
		System.out.println("ok");
		List<Dep> list=depBiz.getList();
		String listString = JSON.toJSONString(list);
		write(listString);
	}
	
	//条件查询
	public void getList(){
		List<Dep> list=depBiz.getList(dep1);
		String listString = JSON.toJSONString(list);
		write(listString);
	}
	
	//类工具：写出json
	public void write(String json){
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf8");
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			System.out.println("exception:com.wan.erp.web.action.DepAction");
			e.printStackTrace();
		}
	}
}
