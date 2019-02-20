package com.atguigu.java;
/*
 * 类的第5个成员：内部类
 * 1.相当于说，我们可以在类的内部再定义类。外面的类：外部类。里面定义的类：内部类
 * 2.内部类的分类：成员内部类（声明在类内部且方法外的）  vs 局部内部类(声明在类的方法里)
 * 3.成员内部类：
 * 		3.1是外部类的一个成员：①可以有修饰符（4个）②static final ③可以调用外部类的属性、方法
 * 			
 * 		3.2具体类的特点：①abstract ②还可以在其内部定义属性、方法、构造器
 * 
 * 4.局部内部类：
 * 
 * 5.关于内部类，大家掌握三点：
 *   ①如何创建成员内部类的对象（如：创建Bird类和Dog类的对象）
 *   ②如何区分调用外部类、内部类的变量(尤其是变量重名时)
 *   ③局部内部类的使用 （见TestInnerClass1.java）
 * 
 */
public class TestInnerClass {
	public static void main(String[] args) {
		//创建静态内部类的对象：可以直接通过外部类调用静态内部类的构造器
		Person.Dog d = new Person.Dog();//Person.new Dog();
		//Person.Bird b = new Person.Bird();
		//创建非静态的内部类的对象：必须先创建外部类的对象，通过外部类的对象调用内部类的构造器
		Person p = new Person();
		Person.Bird b = p.new Bird();//new p.Bird();
		b.info();
		b.setName("杜鹃");
	}
}

class Person{
	String name = "韩梅梅";
	int age;
	//成员内部类(非static的)
	class Bird{
		String name = "黄鹂";
		int id;
		
		public Bird(){
			
		}
		public void setName(String name){
			System.out.println(name);//杜鹃
			System.out.println(this.name);//黄鹂
			System.out.println(Person.this.name);//韩梅梅
		}
		public void info(){
			show();
		}
	}
	//成员内部类(静态内部类)
	static class Dog{
		
	}
	
	public void show(){
		System.out.println("我是show()方法");
	}
	
	public void method1(){
		class A{
			
		}
	}
}