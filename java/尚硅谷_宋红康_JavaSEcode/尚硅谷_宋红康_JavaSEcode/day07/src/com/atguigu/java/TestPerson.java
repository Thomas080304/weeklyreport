package com.atguigu.java;
/*
 * this:
 * 1.可以用来修饰属性、方法、构造器
 * 2.this理解为当前对象或当前正在创建的对象.比如：this.name,this.show();
 * 
 * 3.可以在构造器中通过“this(形参)”的方式显示的调用本类中其它重载的指定的构造器。
 *   要求：1.在构造器内部必须声明在首行！
 *       2.若一个类中有n个构造器，那么最多有n-1个构造器中使用了this(形参);
 * 
 */
public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(10);
		p.info();
		p.setName("李雷");
		p.info();
		System.out.println();
		
		Person p1 = new Person("韩梅梅",23);
		p1.info();
		
		
		Person p2 = new Person(23);
		p2.info();
	}
}

class Person{
	private String name;
	private int age;
	
	public Person(){
//		this("AA");
		name = "Lucy";
		age = 1;
	}
	public Person(String name){
		this(12);
		System.out.println("这是Person类中形参为name的构造器");
		this.name = name;
	}
	public Person(int age){
		this();
		this.age = age;
	}
	//this.name:表示当前正在创建的对象
	//name:是形参
	public Person(String name,int age){
//		this.name = name;
		//this():可以用来显示的调用当前类的重载的指定的构造器。
		this(name);
		System.out.println("这是Person类中形参为name和age的构造器");
		this.age = age;
	}
	//this.name:表示当前对象的属性
	//name:是形参
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	
	public void eat(){
		System.out.println("人吃饭");
	}
	public void sleep(){
		System.out.println("人睡觉");
	}
	//
	public void info(){
		System.out.println("name: " + this.name + " age: " + this.age);
		this.show();
	}
	
	public void show(){
		System.out.println("我是一个人,我的名字是：" + this.name);
	}
	
}
