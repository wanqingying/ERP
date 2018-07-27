package com.wan.erp.dao.impl;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import com.wan.erp.dao.IStoreDao;
import com.wan.erp.entity.Store;
/**
 * 仓库数据访问类
 * @author Administrator
 *
 */
public class StoreDao extends BaseDao<Store> implements IStoreDao {

	/**
	 * 构建查询条件
	 * @param dep1
	 * @param dep2
	 * @param param
	 * @return
	 */
	public DetachedCriteria getDetachedCriteria(Store store1,Store store2,Object param){
		DetachedCriteria dc=DetachedCriteria.forClass(Store.class);
		if(store1!=null){
			if(null != store1.getName() && store1.getName().trim().length()>0){
				dc.add(Restrictions.like("name", store1.getName(), MatchMode.ANYWHERE));
			}

		}
		return dc;
	}

}
