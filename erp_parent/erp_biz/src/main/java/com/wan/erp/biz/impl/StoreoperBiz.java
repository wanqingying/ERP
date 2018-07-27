package com.wan.erp.biz.impl;
import com.wan.erp.biz.IStoreoperBiz;
import com.wan.erp.dao.IStoreoperDao;
import com.wan.erp.entity.Storeoper;
/**
 * 仓库操作记录业务逻辑类
 * @author Administrator
 *
 */
public class StoreoperBiz extends BaseBiz<Storeoper> implements IStoreoperBiz {

	private IStoreoperDao storeoperDao;
	
	public void setStoreoperDao(IStoreoperDao storeoperDao) {
		this.storeoperDao = storeoperDao;
		super.setBaseDao(this.storeoperDao);
	}
	
}
