package com.wan.erp.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
	private Dep dep2;
	private Object param;
	
	
	public Dep getDep2() {
		return dep2;
	}

	public void setDep2(Dep dep2) {
		this.dep2 = dep2;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public Dep getDep1() {
		return dep1;
	}

	public void setDep1(Dep dep1) {
		this.dep1 = dep1;
	}
	
	//分页参数
	private int page;
	private int rows;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	//新增，修改,删除参数模型
	private Dep dep;
	

	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	//查询所有
	public void list(){
		List<Dep> list=depBiz.getList();
		String listString = JSON.toJSONString(list);
		write(listString);
	}
	
	//条件查询
	public void getList(){
		int startind=(page-1)*rows;
		Map<String, Object> data=depBiz.getList(dep1, startind, rows,dep2,param);

		String listString = JSON.toJSONString(data);
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
	public void ajaxReturn(Boolean success, String message){
		Map<String, Object> res=new HashMap<>();
		res.put("success", success);
		res.put("message", message);
		write(JSON.toJSONString(res));
	}
	
	//新增部门
	public void save(){
		Map<String, Object> res=new HashMap<>();
		try {
			depBiz.save(dep);
			res.put("success", true);
			res.put("message", "添加成功");
		} catch (Exception e) {
			res.put("success", false);
			res.put("message", "添加失败");
			e.printStackTrace();
		}
		write(JSON.toJSONString(res));
	}
	
	//删除部门
	public void delete(){
		try {
			depBiz.delete(dep.getUuid());
			ajaxReturn(true, "删除成功");
		} catch (Exception e) {
			ajaxReturn(false, "删除失败");
			e.printStackTrace();
		}
	}
	
	//编辑部门保存
	public void edit(){
		try {
			depBiz.update(dep);
			ajaxReturn(true, "更新成功");
		} catch (Exception e) {
			ajaxReturn(false, "更新失败");
			e.printStackTrace();
		}
	}
	
	//获取部门编辑
	public void get(){
		Dep resdep=depBiz.get(dep.getUuid());
		String jsonstr = JSON.toJSONString(resdep);
		write(mapData(jsonstr, "dep."));
		
	}
	
	//对返回map值进行前缀包装
	public String mapData(String jsonstr,String prefix){
		Map<String, Object> smap=JSON.parseObject(jsonstr);
		Map<String, Object> resmap=new HashMap<>();
		for(String key:smap.keySet()){
			resmap.put(prefix+key, smap.get(key));
		}
		return JSON.toJSONString(resmap);
	}
}
