package com.atguigu.exer;
/*
 * 创建程序,在其中定义两个类：Person和TestPerson类。定义如下：
    用setAge()设置人的合法年龄(0~130)，用getAge()返回人的年龄。
    在TestPerson类中实例化Person类的对象b，调用setAge()和getAge()方法，体会Java的封装性。

 */
public class TestPerson {
	public static void main(String[] args) {
		//Person p = new Person();
		Person p = new Person("刘俊",23);
		p.setAge(120);
//		p.setAge(150);
		System.out.println(p.getName() + ":" + p.getAge());
	}
}

class Person{
	private int age;
	private String name;
	public int getAge(){
		return age;
	}
	
	public void setAge(int a){
		if(a > 0 && a <= 130){
			age = a;
		}else{
			//System.out.println("您输入的数据有误！");
			throw new RuntimeException("您输入的数据有误！");
		}
	}
	
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
//	public Person(){
//		age = 18;
//	}
	public Person(String n,int a){
		name = n;
		age = a;
	}
}