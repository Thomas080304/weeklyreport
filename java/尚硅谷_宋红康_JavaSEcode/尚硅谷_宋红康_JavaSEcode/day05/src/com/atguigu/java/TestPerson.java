package com.atguigu.java;

import java.util.Scanner;

/*
 * 1.面向对象的编程关注于类的设计
 * 2.设计类实际上就是设计类的成员
 * 3.基本的类的成员：属性（成员变量或Field）  & 方法（Method）
 */
public class TestPerson {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.info();
		
		p1.name = "钟超";
		p1.age = 21;
		p1.sex = true;
		p1.info();
		
		p1.setName("付昊");//p1.name = "付昊"
		p1.info();
		
		Person p2 = p1;
		System.out.println("p1:" + p1);
		System.out.println("p2:" + p2);
		p2.info();
		
		p2 = new Person();
		System.out.println("p2:" + p2);
		p2.info();
		
		//实例化Scanner类的对象，通过此对象.nextXxx()调用，完成相应的功能。
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		
		Person p3 = new Person();
		p3.info();
	}
}
//类：是抽象的。
class Person{
	//1.属性：
	String name;
	int age = 10;
	boolean sex;
	
	//2.方法
	public void eat(){
		System.out.println("人吃饭");
	}
	public void sleep(){
		System.out.println("人睡觉");
	}
	
	public String getName(){
		return name;
	}
	//给属性name赋值
	public void setName(String n){
		name = n;
	}
	
	public void info(){
//		eat();
//		sleep();
		System.out.println("name:" + name + " age:" + age + " sex:" + sex);
	}
}


