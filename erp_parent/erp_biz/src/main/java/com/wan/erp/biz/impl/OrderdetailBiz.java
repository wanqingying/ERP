package com.wan.erp.biz.impl;
import com.wan.erp.biz.IOrderdetailBiz;
import com.wan.erp.dao.IOrderdetailDao;
import com.wan.erp.entity.Orderdetail;
/**
 * 订单明细业务逻辑类
 * @author Administrator
 *
 */
public class OrderdetailBiz extends BaseBiz<Orderdetail> implements IOrderdetailBiz {

	private IOrderdetailDao orderdetailDao;
	
	public void setOrderdetailDao(IOrderdetailDao orderdetailDao) {
		this.orderdetailDao = orderdetailDao;
		super.setBaseDao(this.orderdetailDao);
	}
	
}
