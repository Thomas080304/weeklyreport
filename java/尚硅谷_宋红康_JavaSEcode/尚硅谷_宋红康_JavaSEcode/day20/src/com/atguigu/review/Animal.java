package com.atguigu.review;

public class Animal {
	private String name;
	public int age;
	static String desc = "我是一个动物";
	
	public Animal() {
		super();
		System.out.println("!!!");
	}

	private Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public static void info(){
		System.out.println("动物");
	}
	
	public void show(String desc){
		System.out.println("我是一个：" + desc);
	}
	
	
	
	private int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static String getDesc() {
		return desc;
	}

	public static void setDesc(String desc) {
		Animal.desc = desc;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	
	
}
