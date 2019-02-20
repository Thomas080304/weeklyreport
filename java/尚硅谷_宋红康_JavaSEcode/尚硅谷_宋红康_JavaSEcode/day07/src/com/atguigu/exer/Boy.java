package com.atguigu.exer;

public class Boy {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void marry(Girl girl){
		System.out.println("我要娶" + girl.getName());
	}
	
	public void marry(Boy boy){
		System.out.println("我要娶" + boy.getName());
	}
	
	public void shout(){
		if(this.age >= 22){
			System.out.println("我到了结婚年龄了！");
		}else{
			System.out.println("还是先谈谈恋爱吧");
		}
	}
}
