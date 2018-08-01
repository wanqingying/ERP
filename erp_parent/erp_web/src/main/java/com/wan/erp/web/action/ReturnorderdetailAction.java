package com.wan.erp.web.action;
import com.wan.erp.biz.IReturnorderdetailBiz;
import com.wan.erp.entity.Returnorderdetail;

/**
 * 退货订单明细Action 
 * @author Administrator
 *
 */
public class ReturnorderdetailAction extends BaseAction<Returnorderdetail> {

	private IReturnorderdetailBiz returnorderdetailBiz;

	public void setReturnorderdetailBiz(IReturnorderdetailBiz returnorderdetailBiz) {
		this.returnorderdetailBiz = returnorderdetailBiz;
		super.setBaseBiz(this.returnorderdetailBiz);
	}

}
