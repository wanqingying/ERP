package com.wan.erp.test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wan.erp.dao.impl.DepDao;

public class DepDaoTest_start {
	
	@SuppressWarnings("resource")
	@Test
	public void testDep(){
		System.out.println("1");
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath*:applicationContext_*.xml");
		System.out.println("2");
		System.out.println(ac.containsBeanDefinition("depDao"));
		System.out.println(ac.containsBean("depDao"));
		System.out.println(ac.getBeanDefinitionCount());
		DepDao depDao=(DepDao) ac.getBean("depDao");
		System.out.println(depDao.getList().size());
	}

}
