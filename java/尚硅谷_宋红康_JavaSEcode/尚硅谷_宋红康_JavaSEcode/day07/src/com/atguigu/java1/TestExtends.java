package com.atguigu.java1;
/*
 * 一、面向对象的特征二：继承性
 * 1.为什么要设计继承性？
 * 
 * 2.通过"class A extends B"类实现类的继承。
 *   子类：A  父类（或基类 SuperClass）：B
 *   
 * 3.子类继承父类以后，父类中声明的属性、方法，子类就可以获取到。
 *    明确：当父类中有私有的属性或方法时，子类同样可以获取得到，只是由于封装性的设计，使得子类不可以直接
 *        调用罢了。
 *   子类除了通过继承，获取父类的结构之外，还可以定义自己的特有的成分。
 *   
 *   extends：子类是对父类功能的“扩展”，明确子类不是父类的子集。
 *   
 * 4.java中类的继承性只支持单继承：一个类只能继承一个父类。反之，一个父类可以有多个子类。
 * 5.子父类是相对的概念。
 * 
 * 二、方法的重写   ---(方法的重载)     修饰符  返回值类型 方法名 （参数列表）{}
 * 1.前提：有子类继承父类
 * 2.子类继承父类以后，若父类的方法对子类不适用，那么子类可以对父类的方法重写(override overwrite)、覆盖、覆写。
 * 3.重写的规则：  1)要求子类方法的“返回值类型 方法名 （参数列表）”与父类的方法一样
 * 			  2)子类方法的修饰符不能小于父类方法的修饰符
 * 			  3)*若父类方法抛异常，那么子类方法抛的异常类型不能大于父类的。
 * 			  4)*子父类的方法必须同为static或同为非static的。
 */
public class TestExtends {
	public static void main(String[] args) {
		Student s = new Student();
		s.eat();
		
		Worker w = new Worker();
		w.eat();
		
		Person p = new Person();
		p.eat();
		
		s.setAge(12);
		s.setName("麻华龙");
		System.out.println(s.getName() + ":" + s.getAge());
		
		Graduate g = new Graduate();
		g.eat();
		g.info();
		g.show();
	}
}
