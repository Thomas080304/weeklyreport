package com.atguigu.java1;

public class Man extends Person{
	 boolean smoking;
	 int id = 1002;
	public Man() {
		super();
	}
	
	public Man(boolean smoking) {
		super();
		this.smoking = smoking;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}
	
	public void walk(){
		System.out.println("男人笔挺的走路");
	}
	public void eat(){
		System.out.println("男人应该多吃肉！");
	}
	
	public void entertainment(){
		System.out.println("男人请客");
	}
}
