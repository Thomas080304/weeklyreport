package com.atguigu.java;

public class TestCar {
	public static void main(String[] args){
		Car c1 = new Car();
		c1.info();
		
//		c1.setName("玛莎拉蒂");
//		c1.setWheel(4);
		c1.name = "劳斯莱斯";
		c1.wheel = 6;
		
		c1.info();
		
		
		Factory f = new Factory();
		Car c2 = f.produceCar();
		f.describeCar(c2);
		
		Car c3 = f.produceCar("奥拓",4);
		f.describeCar(c3);
	}
}

class Factory{
	
	//制造车(两个方法构成重载)
	public Car produceCar(){
		return new Car();
	}
	
	public Car produceCar(String n,int w){
		Car c = new Car();
		c.name = n;
		c.wheel = w;
		return c;
	}
	//描述车的信息
	public void describeCar(Car c){
		c.info();
	}
}

class Car{
	//1.属性
	String name;
	int wheel;

	//2.方法
	public void info(){
//		show();
		System.out.println("name:" + name + " wheel:" + wheel);
	}
	
	public void show(){
		System.out.println("我是一辆车");
	}
	
	public String getName(){
		return name;
	}
	
//	public void setName(String n){
//		name = n;
//	}
//	public void setWheel(int w){
//		wheel = w;
//	}
}
