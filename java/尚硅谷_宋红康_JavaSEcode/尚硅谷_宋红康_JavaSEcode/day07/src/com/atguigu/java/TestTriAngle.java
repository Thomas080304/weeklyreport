package com.atguigu.java;
/*
 * 编写两个类，TriAngle和TestTriAngle，其中TriAngle中声明私有的底边长base和高height，
 * 同时声明公共方法访问私有变量；另一个类中使用这些公共方法，计算三角形的面积。

 */
public class TestTriAngle { //Angle:角      Angel:天使   host    guest
	public static void main(String[] args) {
		TriAngle t = new TriAngle();
		t.setBase(2.3);
		t.setHeight(1.2);
		System.out.println("面积为：" + t.findArea());
	}
}

class TriAngle{//三角形
	private double base;//底边长
	private double height;//高
	
	public TriAngle(){
		this.base = 1.0;
		this.height = 1.0;
	}
	
	public TriAngle(double base,double height){
		this.base = base;
		this.height = height;
	}
	
	public double getBase(){
		return base;
	}
	public double getHeight(){
		return height;
	}
	
	public void setBase(double base){
		this.base = base;
	}
	public void setHeight(double height){
		this.height = height;
	}
	
	public double findArea(){
		return this.base * this.height / 2;
	}
}
