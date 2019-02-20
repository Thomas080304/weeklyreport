package com.atguigu.exer1;
/*
 * 在Kids类的main方法中实例化Kids的对象someKid，用该对象访问其父类的成员变量及方法。

 */
public class TestKids {
	public static void main(String[] args) {
		Kids someKid = new Kids();
		
		someKid.setSalary(0);
		someKid.setSex(1);
		someKid.setYearsOld(13);
		
		someKid.employees();
		someKid.manOrWoman();
		someKid.printAge();
	}
}
