package com.wan.erp.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.wan.erp.biz.IBaseBiz;

/**
 * 通用Action
 * @author imwan
 *
 */
public class BaseAction<T> {
	
	//	注入服务
	@SuppressWarnings("rawtypes")
	private IBaseBiz baseBiz;

	@SuppressWarnings("rawtypes")
	public void setBaseBiz(IBaseBiz baseBiz) {
		this.baseBiz = baseBiz;
	}
	private String baseprefix;
	
	
	public void setBaseprefix(String prefix) {
		this.baseprefix = prefix;
	}
	//条件查询模型
	private T t1; 
	private T t2;
	private Object param;
	
	
	public T getT2() {
		return t2;
	}

	public void setT2(T t2) {
		this.t2 = t2;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public T getT1() {
		return t1;
	}

	public void setT1(T t1) {
		this.t1 = t1;
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
	private T t;
	private Long uuid;
	

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	//条件查询
	@SuppressWarnings("unchecked")
	public void getList(){
		int startind=(page-1)*rows;
		Map<String, Object> data=baseBiz.getList(t1, startind, rows,t2,param);

		String listString = JSON.toJSONString(data);
		write(listString);
	}
	
	//类工具：写出json
	public void write(String json){
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf8");
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
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
	@SuppressWarnings("unchecked")
	public void save(){
		Map<String, Object> res=new HashMap<>();
		try {
			baseBiz.save(t);
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
			baseBiz.delete(uuid);
			ajaxReturn(true, "删除成功");
		} catch (Exception e) {
			ajaxReturn(false, "删除失败");
			e.printStackTrace();
		}
	}
	
	//编辑部门保存
	public void edit(){
		try {
			System.out.println("ent:"+t);
			baseBiz.update(t);
			ajaxReturn(true, "更新成功");
		} catch (Exception e) {
			ajaxReturn(false, "更新失败");
			e.printStackTrace();
		}
	}
	
	//获取编辑
	@SuppressWarnings("unchecked")
	public void get(){
		T rest=(T) baseBiz.get(uuid);
		String jsonstr = JSON.toJSONString(rest);
		write(mapData(jsonstr, baseprefix));
		
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
