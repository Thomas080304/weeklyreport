package com.atguigu.java1;
/*
 * 一、类的第三个成员：构造器(constructor 构造方法)   construction  CCB  ICBC   oop
 * constructor:建造者 
 * 构造器的作用：①创建对象 ②给创建的对象的属性赋值
 * 
 * 1.设计类时，若不显式声明类的构造器的话，程序会默认提供一个空参的构造器
 * 2.一旦显式的定义类的构造器，那么默认的构造器就不再提供。
 * 3.如何声明类的构造器。格式：权限修饰符  类名(形参){ }
 * 4.类的多个构造器之间构成重载
 * 
 * 
 * 二、类对象的属性赋值的先后顺序：①属性的默认初始化 ②属性的显式初始化③通过构造器给属性初始化
 * 						  ④通过"对象.方法"的方式给属性赋值
 * 
 */
public class TestPerson {
	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println(p1.getName() + ":" + p1.getAge());
		String str = new String("atguigu.com");
		System.out.println(str);
		
		Person p2 = new Person("高鹏");
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		
		Person p3 = new Person("李岳",23);
		System.out.println("name:" + p3.getName() + " age:" + p3.getAge());
		//体会属性赋值的过程
		Person p4 = new Person();
		System.out.println("name:" + p4.getName() + " age:" + p4.getAge());
		
		Person p5 = new Person(12);
		System.out.println("name:" + p5.getName() + " age:" + p5.getAge());
	}
}
class Person{
	//属性
	private String name;
	private int age = 1;
	
	//构造器
	public Person(String n){
		name = n;
	}
	public Person(){
//		age = 10;
//		name = "张三";
	}
	public Person(int a){
		age = a;
	}
	public Person(String n,int a){
		name = n;
		age = a;
	}
	
	//方法
	public void setName(String n){
		name = n;
	}
	public void setAge(int a){
		age = a;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}
