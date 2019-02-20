package com.atguigu.java1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

public class TestIterator {
	//面试题：
	@Test
	public void testFor3(){
		String[] str = new String[]{"AA","BB","DD"};
		for(String s : str){
			s =  "MM";//此处的s是新定义的局部变量，其值的修改不会对str本身造成影响。
			System.out.println(s);
		}		
		
		for(int i = 0;i < str.length;i++){
			System.out.println(str[i]);
		}
	}
	@Test
	public void testFor2(){
		String[] str = new String[]{"AA","BB","DD"};
		for(int i = 0;i < str.length;i++){
			str[i] = i + "";
		}
		
		for(int i = 0;i < str.length;i++){
			System.out.println(str[i]);
		}
	}
	
	//***********************************************
	//使用增强for循环实现数组的遍历
	@Test
	public void testFor1(){
		String[] str = new String[]{"AA","BB","DD"};
		for(String s:str){
			System.out.println(s);
		}
	}
	
	//使用增强for循环实现集合的遍历
	@Test
	public void testFor(){
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(new String("AA"));
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 23));
		
		for(Object i:coll){
			System.out.println(i);
		}
	}
	
	//错误的写法
	@Test
	public void test2(){
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(new String("AA"));
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 23));
		
		Iterator i = coll.iterator();
		
		while((i.next())!= null){
			//java.util.NoSuchElementException
			System.out.println(i.next());
		}
	}
	//正确的写法：使用迭代器Iterator实现集合的遍历
	@Test
	public void test1(){
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(new String("AA"));
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 23));
		
		Iterator i = coll.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
