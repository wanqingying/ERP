package com.wan.erp.biz.impl;
import com.wan.erp.biz.ISupplierBiz;
import com.wan.erp.dao.ISupplierDao;
import com.wan.erp.entity.Supplier;
/**
 * 供应商业务逻辑类
 * @author Administrator
 *
 */
public class SupplierBiz extends BaseBiz<Supplier> implements ISupplierBiz {

	private ISupplierDao supplierDao;
	
	public void setSupplierDao(ISupplierDao supplierDao) {
		this.supplierDao = supplierDao;
		super.setBaseDao(this.supplierDao);
	}
	
}
