package com.atguigu.review;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflection {
	
	//调用指定的方法
	@Test
	public void test4() throws Exception{
		Class clazz = Class.forName("com.atguigu.review.Animal");
		Object obj = clazz.newInstance();
		Animal a = (Animal)obj;
		
		//调用非public的方法
		Method m1 = clazz.getDeclaredMethod("getAge");
		m1.setAccessible(true);
		int age = (Integer)m1.invoke(a);
		System.out.println(age);
		//调用public的方法
		Method m2 = clazz.getMethod("show", String.class);
		Object returnVal = m2.invoke(a,"金毛");
		System.out.println(returnVal);
		//调用static的方法
		Method m3 = clazz.getDeclaredMethod("info");
		m3.setAccessible(true);
//		m3.invoke(Animal.class);
		m3.invoke(null);
		
	}
	
	//调用指定属性
	@Test
	public void test3() throws Exception{
		Class clazz = Class.forName("com.atguigu.review.Animal");
		Object obj = clazz.newInstance();
		Animal a = (Animal)obj;
		//调用非public的属性
		Field f1 = clazz.getDeclaredField("name");
		f1.setAccessible(true);
		f1.set(a, "Jerry");
		//调用public的属性
		Field f2 = clazz.getField("age");
		f2.set(a, 9);
		System.out.println(f2.get(a));
		System.out.println(a);
		//调用static的属性
		Field f3 = clazz.getDeclaredField("desc");
		System.out.println(f3.get(null));
	}
	
	//调用指定的构造器创建运行时类的对象
	@Test
	public void test2() throws Exception{
		Class clazz = Animal.class;
		Constructor cons = clazz.getDeclaredConstructor(String.class,int.class);
		cons.setAccessible(true);
		Animal a = (Animal)cons.newInstance("Tom",10);
		System.out.println(a);
	}
	
	//获取运行时类的对象：方法一
	@Test
	public void test1() throws Exception{
		Class clazz = Class.forName("com.atguigu.review.Animal");
		Object obj = clazz.newInstance();
		Animal a = (Animal)obj;
		System.out.println(a);
	}
}
