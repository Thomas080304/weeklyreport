package com.atguigu.java1;

public class TestError {
	public static void main(String[] args) {
		//java.lang.StackOverflowError
		//main(args);
		//java.lang.OutOfMemoryError
		byte[] b = new byte[1024*1024*600];
	}
}
