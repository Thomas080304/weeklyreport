/**
这是我的第一个java程序
@author shkstart
@version v1.0
*/
public class HelloJava{
	/*
	1.源文件以.java结尾
	2.源文件中可以有多个class声明的类
	3.类中可以有主方法（即main()方法），其格式是固定的：public static void main(String[] args){}
	4.main()方法是程序的入口，方法内是程序的执行部分。
	5.一个源文件中只能有一个声明为public 的类，同时要求此类的类名与源文件名一致。
	6.每个语句都以";"结束
	7.执行程序：①编译：javac.exe  编译完，生成诸多个.class字节码文件。②运行：java.exe
	8.多行注释不能够嵌套
	*/
	public static void main(String[] args){
		System.out.println("Hello World!" +'\n' +"Hello atguigu.com");
		
	}
}

class Person{

}

class Hello{

}