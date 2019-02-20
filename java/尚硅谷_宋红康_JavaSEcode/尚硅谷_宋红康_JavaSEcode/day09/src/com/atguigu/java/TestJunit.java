package com.atguigu.java;

import org.junit.Test;
/*
 * Junit单元测试类
 * 1.当前工程下-右键build path-add libraries-Junit4
 * 2.在主类中,创建一个空参的无返回值的方法，（如：public void test1()）用于代码的测试，方法上声明：@Test
 * 3.导入import org.junit.Test;
 * 4.在test1()方法中，进行代码的编写。
 * 5.测试：双击方法名，右键run as-junit Test即可。
 */
public class TestJunit {
	public static void main(String[] args) {
		String str = "AA";
		System.out.println(str);
	}
	
	@Test
	public void test2(){
		
	}
	
	@Test
	public void test1(){
		String str = "AA";
		System.out.println(str);
		m1();
	}
	public void m1(){
		System.out.println("hello world");
	}
}
