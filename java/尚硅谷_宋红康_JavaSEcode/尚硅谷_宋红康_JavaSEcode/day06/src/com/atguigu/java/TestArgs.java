package com.atguigu.java;
/*
 * 可变个数的形参的方法：
 * 1.格式：对于方法的形参： 数据类型 ... 形参名
 * 2.可变个数的形参的方法与同名的方法之间构成重载
 * 3.可变个数的形参在调用时，个数从0开始，到无穷多个都可以。
 * 4.使用可变多个形参的方法与方法的形参使用数组是一致的。
 * 5.若方法中存在可变个数的形参，那么一定要声明在方法形参的最后。
 * 6.在一个方法中，最多声明一个可变个数的形参。
 */
public class TestArgs {
	public static void main(String[] args) {
		TestArgs t = new TestArgs();
		t.sayHello();
		//t.sayHello(new String[]{"hello China","hello BeiJing"});
		t.sayHello("hello China","hello BeiJing");
	}
	
	//如下四个方法构成重载
	//在类中一旦定义了重载的可变个数的形参的方法以后，如下的两个方法可以省略
//	public void sayHello(){
//		System.out.println("hello world!");
//	}
//	public void sayHello(String str1){
//		System.out.println("hello " + str1);
//	}
	//可变个数的形参的方法
	public void sayHello(String ... args){
		for(int i = 0;i < args.length;i++){
			System.out.println(args[i] + "$");
		}
		//System.out.println("=====");
	}
	
	public void sayHello(int i,String ... args){
	//public void sayHello(String ... args,int i){
		System.out.println(i);
		
		for(int j = 0;j < args.length;j++){
			System.out.println(args[j] + "$");
		}
	}
	
	public void sayHello1(String[] args){
		for(int i = 0;i < args.length;i++){
			System.out.println(args[i]);
		}
	}
	
	//可变个数形参的使用的例子
//	public int getSum(int i,int j){
//		return i + j;
//	}
//	public int getSum(int i,int j,int k){
//		return i + j + k;
//	}
	public int getSum(int ... args){
		int sum = 0;
		for(int i = 0;i < args.length;i++){
			sum += args[i];
		}
		return sum;
	}
		
}
