package com.wan.erp.web.action;
import com.wan.erp.biz.ISupplierBiz;
import com.wan.erp.entity.Supplier;

/**
 * 供应商Action 
 * @author Administrator
 *
 */
public class SupplierAction extends BaseAction<Supplier> {

	private ISupplierBiz supplierBiz;

	public void setSupplierBiz(ISupplierBiz supplierBiz) {
		this.supplierBiz = supplierBiz; 
		super.setBaseBiz(this.supplierBiz);
	}

}
