package com.atguigu.java;
//接口与具体的实现类之间也存在多态性
public class TestInterface {
	
	public static void main(String[] args) {
		Duck d = new Duck();
		TestInterface.test1(d);
		TestInterface.test2(d);
		TestInterface.test3(d);
	}
	
	public static void test1(Runner r){//Runner r = new Duck();
		r.run();//虚拟方法调用
	}
	public static void test2(Swimmer s){//Swimmer s = new Duck();
		s.swim();
	}
	public static void test3(Flier f){//Flier f = new Duck();
		f.fly();
	}
}

interface Runner{
	public abstract void run();
}
interface Swimmer{
	void swim();
}
interface Flier{
	void fly();
}

class Duck implements Runner,Swimmer,Flier{

	@Override
	public void fly() {
		System.out.println("丑小鸭也可以变成白天鹅！");
	}

	@Override
	public void swim() {
		System.out.println("红掌拨清波");
	}

	@Override
	public void run() {
		System.out.println("鸭子屁股扭扭的走路");
	}
	
}
