package com.wan.erp.web.action;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.wan.erp.biz.IOrdersBiz;
import com.wan.erp.entity.Emp;
import com.wan.erp.entity.Orderdetail;
import com.wan.erp.entity.Orders;

/**
 * 订单Action 
 * @author Administrator
 *
 */
public class OrdersAction extends BaseAction<Orders> {

	private IOrdersBiz ordersBiz;

	private String json;
	 
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public void setOrdersBiz(IOrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
		super.setBaseBiz(this.ordersBiz); 
	}
	
	public void add(){
		
		try {
			Orders orders=getT();
			Emp loginuser=getLoginUser();
		if(null==loginuser){
			ajaxReturn(false, "添加失败，请登录后操作");
			return;
		}
			orders.setCreater(loginuser.getUuid());
			List<Orderdetail> odList=JSON.parseArray(json, Orderdetail.class);
			orders.setOrderDetails(odList);
			ordersBiz.add(orders);
			ajaxReturn(false, "添加成功");
		} catch (Exception e) {
			ajaxReturn(false, "添加失败，系统错误");
			e.printStackTrace();
		}
		
	}

}
