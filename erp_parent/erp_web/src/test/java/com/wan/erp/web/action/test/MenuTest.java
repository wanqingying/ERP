package com.wan.erp.web.action.test;

import org.junit.Test;

import com.wan.erp.biz.impl.MenuBiz;
import com.wan.erp.entity.Menu;

public class MenuTest {
	
	@Test
	public void Test1(){
		Menu ms=new MenuBiz().get("0");
		System.out.println(ms);
	}
}
