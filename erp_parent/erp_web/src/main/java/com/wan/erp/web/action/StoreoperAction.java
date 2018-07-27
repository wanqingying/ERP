package com.wan.erp.web.action;
import com.wan.erp.biz.IStoreoperBiz;
import com.wan.erp.entity.Storeoper;

/**
 * 仓库操作记录Action 
 * @author Administrator
 *
 */
public class StoreoperAction extends BaseAction<Storeoper> {

	private IStoreoperBiz storeoperBiz;

	public void setStoreoperBiz(IStoreoperBiz storeoperBiz) {
		this.storeoperBiz = storeoperBiz;
		super.setBaseBiz(this.storeoperBiz);
	}

}
