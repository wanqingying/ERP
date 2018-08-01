package com.wan.erp.web.action;
import com.wan.erp.biz.IEmpBiz;
import com.wan.erp.entity.Emp;

/**
 * 员工Action 
 * @author Administrator
 *
 */
public class EmpAction extends BaseAction<Emp> {

	//注入服务
	private IEmpBiz empBiz;

	public void setEmpBiz(IEmpBiz empBiz) {
		this.empBiz = empBiz;
		super.setBaseBiz(this.empBiz);
	}
	
	private String oldPwd;//旧密码
	private String newPwd;//新密码

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	//新增，删除，修改模型
	public Emp emp;

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
		super.setT(emp);
	}
	
	/**
	 * 修改密码调用的方法
	 */
	public void updatePwd(){
		Emp loginUser = getLoginUser();
		//session是否会超时，用户是否登陆过了
		if(null == loginUser){
			ajaxReturn(false, "亲，您还没有登陆");
			return;
		}
		try {
			empBiz.updatePwd(loginUser.getUuid(), oldPwd, newPwd);
			ajaxReturn(true, "修改密码成功");
		} catch (Exception e) {
			e.printStackTrace();
			ajaxReturn(false, "修改密码失败");
		}
	}
	
	/**
	 * 重置密码调用的方法
	 */
	public void updatePwd_reset(){
		
		try {
			empBiz.updatePwd_reset(getId(), newPwd);
			ajaxReturn(true, "重置密码成功");
		} catch (Exception e) {
			e.printStackTrace();
			ajaxReturn(false, "重置密码失败");
		}
	}
}
