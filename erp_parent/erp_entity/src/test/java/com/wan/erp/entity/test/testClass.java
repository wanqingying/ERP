package com.wan.erp.entity.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.wan.erp.entity.Emp;

public class testClass {

	@Test
	public void test1() throws NoSuchMethodException, SecurityException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Emp emp=new Emp();
		 Method[] fs = emp.getClass().getDeclaredMethods();
		for(Method f:fs){
			if(f.getName().equals("setTele")){
				f.invoke(emp, "444455");
			}
			System.out.println(emp.getTele());
			System.out.println("ol");
		}
		System.out.println();
	}
}
