package com.atguigu.exer;

public class ReturnExceptionDemo {
	static void methodA() {
		try {
			System.out.println("进入方法A");
			throw new RuntimeException("制造异常");
		} finally {
			System.out.println("用A方法的finally");
		}}
	static int methodB() {
		try {
			System.out.println("进入方法B");
			return 1;
		} finally {
			System.out.println("调用B方法的finally");
			return 2;
		}}
	public static void main(String[] args) {
		try {
			methodA();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int i = methodB();
		System.out.println(i);
	}
}
