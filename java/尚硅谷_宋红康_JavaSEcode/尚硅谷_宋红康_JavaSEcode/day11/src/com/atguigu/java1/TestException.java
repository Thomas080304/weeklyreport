package com.atguigu.java1;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;
/*一、异常的体系结构
 * java.lang.Throwable
 * 		|-----Error:错误，程序中不进行处理
 * 		|-----Exception:异常，要求在编写程序时，就要考虑到对这些异常的处理
 * 				|-----编译时异常：在编译期间会出现的异常（执行javac.exe命令时，出现异常） 
 * 				|-----运行时异常：在运行期间出现的异常(执行java.exe命令时，出现异常)
 * 
 * 当执行一个程序时，如果出现异常，那么异常之后的代码就不再执行！
 */
public class TestException {
	//编译时异常
	@Test
	public void test6(){
//		FileInputStream fis = new FileInputStream(new File("hello.txt"));
//		int b;
//		while((b = fis.read()) != -1){
//			System.out.println((char)b);
//		}
//		fis.close();
	}
	
	//常见的运行时异常
	/*
	 * Bank bank = new Bank();
	 * Customer[] customers = new Customer[5];
	 * customers[0] = new Customer();
	 * System.out.println(customers[0].getFirstName());可能出现空指针异常
	 * customers[0].setAccount(new Account(200));
	 * customers[0].getAccount().withdraw(100);可能出现空指针异常
	 */
	//4.空指针异常：NullPointerExcetion
	@Test
	public void test5(){
//		Person p = new Person();
//		p = null;
//		System.out.println(p.toString());
		
		String str = new String("AA");
		str = null;
		System.out.println(str.length());
	}
	
	//3.类型转换异常：ClassCastException
	@Test
	public void test4(){
		Object obj = new Date();
		String str = (String)obj;
		
		//String str1 = (String)new Date();
	}
	
	//2.算术异常：ArithmeticException
	@Test
	public void test3(){
		int i = 10;
		System.out.println(i / 0);
	}
	
	//1.数组下标越界的异常:ArrayIndexOutOfBoundsException
	@Test
	public void test2(){
		int[] i = new int[10];
		//System.out.println(i[10]);
		System.out.println(i[-10]);
	}
	
	@Test
	public void test1(){
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		System.out.println(i);
	}
}
class Person{
	
}
