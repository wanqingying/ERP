package com.wan.erp.biz.impl;
import java.util.Date;

import com.wan.erp.biz.IOrdersBiz;
import com.wan.erp.dao.IOrdersDao;
import com.wan.erp.entity.Orderdetail;
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
	
	public void add(Orders orders){
		orders.setState(Orders.STATE_CREATE);
		orders.setType(Orders.TYPE_IN);
		orders.setCreatetime(new Date());
		
		double total=0;
		for(Orderdetail de : orders.getOrderDetails()){
			total+=de.getMoney();
			de.setState(Orderdetail.STATE_NOT_IN);
			de.setOrders(orders);
		}
		orders.setTotalmoney(total);
		ordersDao.add(orders);
	}
}
