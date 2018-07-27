package com.wan.erp.web.action;
import com.wan.erp.biz.IGoodstypeBiz;
import com.wan.erp.entity.Goodstype;

/**
 * 商品分类Action 
 * @author Administrator
 *
 */
public class GoodstypeAction extends BaseAction<Goodstype> {

	private IGoodstypeBiz goodstypeBiz;

	public void setGoodstypeBiz(IGoodstypeBiz goodstypeBiz) {
		this.goodstypeBiz = goodstypeBiz;
		super.setBaseBiz(this.goodstypeBiz);
	}

}
