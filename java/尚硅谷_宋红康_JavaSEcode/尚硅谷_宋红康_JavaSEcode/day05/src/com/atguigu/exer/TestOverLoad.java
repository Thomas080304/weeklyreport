package com.atguigu.exer;

/*
 * 题目一：
 * 编写程序，定义三个重载方法并调用。方法名为mOL。
 三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，
 相乘并输出结果，输出字符串信息。
 在主类的main ()方法中分别用参数区别调用三个方法。
题目二：
定义三个重载方法max()，第一个方法求两个int值中的最大值，
第二个方法求两个double值中的最大值，
第三个方法求三个double值中的最大值，并分别调用三个方法。


 */
public class TestOverLoad {
	public static void main(String[] args) {
		TestOverLoad t = new TestOverLoad();
		t.mOL(12);
		t.mOL("www.atguigu.com");
		
		System.out.println(t.max(12, 13));
		System.out.println(t.max(12.1,23.4));
	}
	public double max(double d1,double d2,double d3){
		return (max(d1,d2) > d3)? max(d1,d2) : d3;
	}
	public double max(double d1,double d2){
		//System.out.println("double!!!");
		return (d1 > d2)? d1 : d2;
	}
	public int max(int i,int j){
		return (i > j)? i : j;
	}
	//以上三个方法构成重载
	
	//以下三个方法构成重载
	public void mOL(int i) {
		System.out.println(i * i);
	}

	public void mOL(int i, int j) {
		System.out.println(i * j);
	}

	public void mOL(String str) {
		System.out.println(str);
	}
}
