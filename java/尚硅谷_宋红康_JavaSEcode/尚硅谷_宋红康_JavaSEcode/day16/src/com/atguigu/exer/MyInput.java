package com.atguigu.exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Create a program named MyInput.java: 
 * Contain the methods for reading int, double, float, boolean, short, 
 * byte and String values from the keyboard

 */
public class MyInput {
	
	
	public String nextString(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	public int nextInt(){
		return Integer.parseInt(nextString());
	}
	public boolean nextBoolean(){
		return Boolean.parseBoolean(nextString());
	}
	public static void main(String[] args) {
		MyInput i = new MyInput();
		System.out.println("ÇëÊäÈëÒ»¸ö×Ö·û´®£º");
		String str = i.nextString();
		System.out.println(str);
		
		int j = i.nextInt();
		System.out.println(j + 1);
	}
}
