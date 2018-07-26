package com.wan.erp.entity;
/**
 * 部门
 * @author imwan
 *
 */

public class Dep {
	
	/**
	 * 部门编号
	 */
	private Long uuid;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 联系电话
	 */
	private String tele;
	
	/**
	 * getter/setter
	 */
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	
	public Dep() {
		super();
	}
	
}
