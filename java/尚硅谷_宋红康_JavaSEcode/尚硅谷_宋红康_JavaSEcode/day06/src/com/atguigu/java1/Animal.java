package com.atguigu.java1;

public class Animal{
	//private 修饰的属性，只能在本类中被调用，出了此类，就不能被调用了。
	private String name;//动物的名字
	private int legs;//腿的个数
	String color;
	public double weight;
	
	void eat(){
		System.out.println("动物进食");
	}
	public void sleep(){
		System.out.println("动物睡觉");
	}
	public void info(){
		System.out.println("name:" + name + " legs:" + legs);
	}
	//设置类的属性
	public void setLegs(int l){
		if(l > 0 && l % 2 == 0){
			legs = l;
		}else{
			System.out.println("您输入的数据有误！");
		}
	}
	//获取类的属性
	public int getLegs(){
		return legs;
	}
	
//	public int doLegs(int l){
//		legs = l;
//		return legs;
//	}
	
	public void setName(String n){
		//....
		name = n;
	}
	public String getName(){
		return name;
	}
}
