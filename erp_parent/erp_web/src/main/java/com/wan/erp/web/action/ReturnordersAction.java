package com.wan.erp.web.action;
import com.wan.erp.biz.IReturnordersBiz;
import com.wan.erp.entity.Returnorders;

/**
 * 退货订单Action 
 * @author Administrator
 *
 */
public class ReturnordersAction extends BaseAction<Returnorders> {

	private IReturnordersBiz returnordersBiz;

	public void setReturnordersBiz(IReturnordersBiz returnordersBiz) {
		this.returnordersBiz = returnordersBiz;
		super.setBaseBiz(this.returnordersBiz);
	}

}
