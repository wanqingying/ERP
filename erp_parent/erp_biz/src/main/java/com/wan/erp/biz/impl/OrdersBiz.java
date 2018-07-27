package com.wan.erp.biz.impl;
import com.wan.erp.biz.IOrdersBiz;
import com.wan.erp.dao.IOrdersDao;
import com.wan.erp.entity.Orders;
/**
 * 订单业务逻辑类
 * @author Administrator
 *
 */
public class OrdersBiz extends BaseBiz<Orders> implements IOrdersBiz {

	private IOrdersDao ordersDao;
	
	public void setOrdersDao(IOrdersDao ordersDao) {
		this.ordersDao = ordersDao;
		super.setBaseDao(this.ordersDao);
	}
	
}
