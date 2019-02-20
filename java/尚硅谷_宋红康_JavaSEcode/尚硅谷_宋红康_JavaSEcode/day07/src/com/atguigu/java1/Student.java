package com.atguigu.java1;
class A{
	
}

public class Student extends Person{
//public class Student extends Person,A{
//	private String name;
//	private int age;
	private String schoolName;
	
	public Student(){
		
	}
	public Student(String name,int age){
//		this.name = name;
//		this.age = age;
		this.setName(name);
		this.setAge(age);
	}
	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//	对父类同名的方法的重写、覆盖
	public void eat(){
		System.out.println("应该多吃有营养的");
	}
	public void walk(){
		System.out.println("背着书包蹦蹦跳跳的走路");
	}
	public void info(){
		eat();
		//System.out.println("name:" + name);
		System.out.println("我是一个学生");
	}
	//不是对父类私有的sleep()方法的重写。
	private int sleep(){
		return 0;
	}
	
}
