package com.atguigu.java1;
/*
 * abstract:抽象的,可以用来修饰类、方法
 * 
 * 1.abstract修饰类：抽象类
 * 1)不可被实例化
 * 2)抽象类有构造器 (凡是类都有构造器)
 * 3)抽象方法所在的类，一定是抽象类。
 * 4)抽象类中可以没有抽象方法。
 * 
 * 2.abstract修饰方法：抽象方法
 * 1)格式：没有方法体，包括{}.如：public abstract void eat();
 * 2)抽象方法只保留方法的功能，而具体的执行，交给继承抽象类的子类，由子类重写此抽象方法。
 * 3)若子类继承抽象类，并重写了所有的抽象方法，则此类是一个"实体类",即可以实例化
 * 4)若子类继承抽象类，没有重写所有的抽象方法，意味着此类中仍有抽象方法，则此类必须声明为抽象的！
 * 
 */
public class TestAbstract {
	public static void main(String[] args) {
		//Person p1 = new Person();
		//p1.eat();
		
		Student s = new Student();
		s.eat();
		
		Person p = new Student();//多态
		p.eat();
		
	}
}

abstract class Creator{
	abstract void breath();
}

abstract class Person extends Creator{
	String name;
	public abstract void eat();
	public abstract void walk();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(){
		
	}
	public Person(String name){
		this.name = name;
	}
}
class Student extends Person{
	public void eat(){
		System.out.println("学生吃饭");
	}
	public void walk(){
		System.out.println("学生走路");
	}
	@Override
	void breath() {
		System.out.println("学生不应该呼吸雾霾的空气");
	}
}

abstract class Worker extends Person{
	public void eat(){
		System.out.println("工人吃饭");
	}
//	public void walk(){
//		System.out.println("工人走路");
//	}
}

class Animal{
	//不是抽象方法！
	public void sleep(){
		
	}
}