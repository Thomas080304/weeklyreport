package com.atguigu.exer;
/*
 * 要求：(1)创建Person类的对象，设置该对象的name、age和sex属性，调用study方法，
 * 输出字符串“studying”，调用showAge()方法显示age值，调用addAge()方法给对象
 * 的age属性值增加2岁。
(2)创建第二个对象，执行上述操作，体会同一个类的不同对象之间的关系。

 */
//测试类
public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person();
		p.study();
		p.showAge();
		p.addAge(2);
		p.showAge();
		
		Person p1 = new Person();
		p1.showAge();//0
	}
}
class Person{
	//1.属性
	String name;
	int age;
	int sex;
	//2.方法
	public void study(){
		System.out.println("studying");
	}
	public void showAge(){
		System.out.println(age);//打印调用showAge()方法的对象的age属性
	}
	//给调用此方法的对象的age属性增加i岁，并返回新的age
	public int addAge(int i){
		age += i;
		return age;
	}
}
