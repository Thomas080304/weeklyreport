package com.atguigu.java1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

/*
 * 二、如何处理Exception的异常
 * Java提供的是异常处理的抓抛模型
 * 1."抛"：当我们执行代码时，一旦出现异常，就会在异常的代码处生成一个对应的异常类型的对象，并
 *        将此对象抛出。(自动抛出   / 手动抛出)
 *        >一旦抛出此异常类的对象，那么程序就终止执行
 *        >此异常类的对象抛给方法的调用者。
 * 2."抓"：抓住上一步抛出来的异常类的对象。如何抓？即为异常处理的方式
 *    java 提供了两种方式用来处理一个异常类的对象。
 *    处理的方式一：
 *    try{
 *    	//可能出现异常的代码
 *    }catch(Exception1 e1){
 *    	//处理的方式1
 *    }catch(Exception2 e2){
 *    	//处理的方式2
 *    }finally{
 *    	//一定要执行的代码 
 *    }
 * 注：1.try内声明的变量，类似于局部变量，出了try{}语句，就不能被调用
 *    2.finally是可选的。
 *    3.catch语句内部是对异常对象的处理：
 *        >getMessage();  printStackTrace();
 *    4.可以有多个catch语句，try中抛出的异常类对象从上往下去匹配catch中的异常类的类型，一旦满足
 *      就执行catch中的代码。执行完，就跳出其后的多条catch语句
 *    5.如果异常处理了，那么其后的代码继续执行。
 *    6.若catch中多个异常类型是"并列"关系，孰上孰下都可以。
 *      若catch中多个异常类型是"包含"关系，须将子类放在父类的上面，进行处理。否则报错！
 *    7.finally中存放的是一定会被执行的代码，不管try中、catch中是否仍有异常未被处理，以及是否有return语句。
 *    8.try-catch是可以嵌套的。
 *    
 * 三、对于运行时异常来说，可以不显式的进行处理。
 *    对于编译时异常来说，必须要显式的进行处理。 
 */
public class TestException1 {
	// 编译时异常
	@Test
	public void test6() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("hello.txt"));
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print((char) b);
			}

		} catch (FileNotFoundException e1) {
			System.out.println("文件找不到了！");
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 常见的运行时异常
	// 4.空指针异常：NullPointerExcetion
	@Test
	public void test5() {
		// Person p = new Person();
		// p = null;
		// System.out.println(p.toString());

		try {
			String str = new String("AA");
			str = null;
			System.out.println(str.length());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("出现空指针的异常了");
		}
	}

	// 3.类型转换异常：ClassCastException
	@Test
	public void test4() {
		try {
			Object obj = new Date();
			String str = (String) obj;
		} catch (ClassCastException e) {
			System.out.println("出现类型转换的异常了");
			//System.out.println(10 / 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("hello!美女！");
		}
		// String str1 = (String)new Date();
	}

	// 2.算术异常：ArithmeticException
	@Test
	public void test3() {
		try {
			int i = 10;
			System.out.println(i / 0);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	// 1.数组下标越界的异常:ArrayIndexOutOfBoundsException
	@Test
	public void test2() {
		try {
			int[] i = new int[10];
			// System.out.println(i[10]);
			System.out.println(i[-10]);
		} catch (Exception e) {
			System.out.println("出现异常了！");
		}
	}

	@Test
	public void test1() {
		Scanner s = new Scanner(System.in);
		try {
			int i = s.nextInt();
			System.out.println(i);
		} catch (InputMismatchException e) {
			System.out.println("出现类型不匹配的异常了！");
		}
	}
}
