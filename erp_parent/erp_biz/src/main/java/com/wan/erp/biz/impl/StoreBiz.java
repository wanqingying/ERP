package com.wan.erp.biz.impl;
import com.wan.erp.biz.IStoreBiz;
import com.wan.erp.dao.IStoreDao;
import com.wan.erp.entity.Store;
/**
 * 仓库业务逻辑类
 * @author Administrator
 *
 */
public class StoreBiz extends BaseBiz<Store> implements IStoreBiz {

	private IStoreDao storeDao;
	
	public void setStoreDao(IStoreDao storeDao) {
		this.storeDao = storeDao;
		super.setBaseDao(this.storeDao);
	}
	
}
