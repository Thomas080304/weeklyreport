package com.atguigu.java1;

/*
 * 面向对象的特征三：多态性
 * 1.多态性指的是什么？多态性，可以理解为一个事物的多种表型形态。 
 *   1）方法的重载与重写  2）子类对象的多态性
 * 
 * 2.子类对象的多态性使用的前提：①要有类的继承②要有子类对父类方法的重写
 * 
 * 3.程序运行分为编译状态和运行状态。
 *   对于多态性来说，编译时，"看左边"，将此引用变量理解为父类的类型
 *   运行时，"看右边",关注于真正对象的实体：子类的对象。那么执行的方法就是子类重写的。
 *   
 * 4.子类对象的多态性，并不使用于属性。
 */
public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person();
		p.eat();
		p.walk();

		Man m = new Man();
		m.eat();
		m.walk();
		System.out.println();

		// 子类对象的多态性：父类的引用指向子类对象
		Person p1 = new Man();// 向上转型
		// 虚拟方法调用：通过父类的引用指向子类的对象实体，当调用方法时，实际执行的是子类重写父类的方法
		p1.eat();
		p1.walk();
		System.out.println("$" + p1.id);//1001

//		p1.smoking = null;
		// p1.entertainment();

		Person p2 = new Woman();
		p2.eat();
		p2.walk();
		// p2.shopping();
		Woman w = (Woman) p2;// 向下转型,使用强转符：()
		w.shopping();

		// java.lang.ClassCastException
		// Woman w1 = (Woman)p1;
		// w1.shopping();

		// Woman w2 = (Woman)new Man();
		// instanceof:
		// 格式： 对象a instanceof 类A：判断对象a是否是类A的一个实例.是的话，返回true；否则返回false
		// 若a是A类的实例，那么a也一定是A类的父类的实例。
		if (p1 instanceof Woman) {
			System.out.println("hello!");
			Woman w1 = (Woman) p1;
			w1.shopping();
		}

		if (p1 instanceof Man) {
			Man m1 = (Man) p1;
			m1.entertainment();
		}

		if (p1 instanceof Person) {
			System.out.println("你好！");
		}

	}

	public void show(Person p) {//Person p = new Man();

	}

//	public void show(Man p) {//Man p = new Man();
//
//	}
//
//	public void show(Woman p) {
//
//	}
}
