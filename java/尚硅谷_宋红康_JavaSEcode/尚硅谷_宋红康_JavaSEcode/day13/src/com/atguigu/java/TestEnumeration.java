package com.atguigu.java;

import java.util.Enumeration;
import java.util.StringTokenizer;

//Enumeration 接口是 Iterator 迭代器的 “古老版本”
public class TestEnumeration {
	public static void main(String[] args) {
		Enumeration enu = new StringTokenizer("ab-c*-df-g", "-");
		while(enu.hasMoreElements()){
			System.out.println(enu.nextElement());
		}
	}
}	
