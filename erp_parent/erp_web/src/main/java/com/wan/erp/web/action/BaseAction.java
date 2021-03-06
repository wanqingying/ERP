package com.wan.erp.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionContext;
import com.wan.erp.biz.IBaseBiz;
import com.wan.erp.entity.Emp;

/**
 * 通用Action类
 * @author Administrator
 *
 * @param <T>
 */
public class BaseAction<T> {

	private IBaseBiz<T> baseBiz;
	
	public void setBaseBiz(IBaseBiz<T> baseBiz) {
		this.baseBiz = baseBiz;
	}
	
	//属性驱动:条件查询
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
	
	private int page;//页码
	private int rows;//每页的记录数
	
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
	/**
	 * 条件查询
	 */
	public void list(){
		List<T> list = baseBiz.getList(t1,t2,param);
		//把部门列表转JSON字符串
		String listString = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		write(listString);
	}
	
	public void listByPage(){
		//System.out.println("页码：" + page + " 记录数:" + rows);
		int firstResult = (page -1) * rows;
		List<T> list = baseBiz.getListByPage(t1,t2,param,firstResult, rows);
		long total = baseBiz.getCount(t1,t2,param);
		//{total: total, rows:[]}
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", total);
		mapData.put("rows", list);
		//DisableCircularReferenceDetect禁用循环引用保护
		String listString = JSON.toJSONString(mapData, SerializerFeature.DisableCircularReferenceDetect);
		write(listString);
	}
	
	/**新增，修改*/
	private T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	/**
	 * 新增
	 * @param jsonString
	 */
	public void add(){
		try {
			baseBiz.add(t);
			ajaxReturn(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			ajaxReturn(false, "添加失败");
		}
	}
	
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * 删除
	 * @param jsonString
	 */
	public void delete(){
		
		try {
			baseBiz.delete(id);
			ajaxReturn(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			ajaxReturn(false, "删除失败");
		}
	}
	
	/**
	 * 通过编辑查询对象
	 */
	public void get(){
		T t = baseBiz.get(id);
		String jsonString = JSON.toJSONStringWithDateFormat(t,"yyyy-MM-dd");
		System.out.println("转换前：" + jsonString);
		String jsonStringAfter = mapData(jsonString, "t");
		System.out.println("转换后：" + jsonStringAfter);
		write(jsonStringAfter);
	}
	
	/**
	 * 修改
	 */
	public void update(){
		try {
			System.out.println("ent:"+t);
			baseBiz.update(t);
			ajaxReturn(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			ajaxReturn(false, "修改失败");
		}
	}
	
	/**
	 * @param jsonString JSON数据字符串
	 * @param prefix 要加上的前缀
	 */
	@SuppressWarnings("unchecked")
	public String mapData(String jsonString, String prefix){
		Map<String, Object> map = JSON.parseObject(jsonString);
		
		//存储key加上前缀后的值
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//给每key值加上前缀
		for(String key : map.keySet()){
			if(map.get(key) instanceof Map){
				//key值进行拼接
				Map<String,Object> m2 = (Map<String,Object>)map.get(key);
				for(String key2 : m2.keySet()){
					dataMap.put(prefix + "." + key + "." + key2, m2.get(key2));
				}
			}else{
				dataMap.put(prefix + "." + key, map.get(key));
			}
		}
		return JSON.toJSONString(dataMap);
	}
	
	/**
	 * 返回前端操作结果
	 * @param success
	 * @param message
	 */
	public void ajaxReturn(boolean success, String message){
		//返回前端的JSON数据
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("success",success);
		rtn.put("message",message);
		write(JSON.toJSONString(rtn));
	}
	
	/**
	 * 输出字符串到前端
	 * @param jsonString
	 */
	public void write(String jsonString){
		try {
			//响应对象
			HttpServletResponse response = ServletActionContext.getResponse();
			//设置编码
			response.setContentType("text/html;charset=utf-8"); 
			//输出给页面
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取登陆的用户信息
	 * @return
	 */
	public Emp getLoginUser(){
		return (Emp) ActionContext.getContext().getSession().get("loginUser");
	}
}
