package com.atguigu.exer;
//¶àÌ¬µÄÁ·Ï°5

public class TestInstance {
	public static void main(String[] args) {
		TestInstance t = new TestInstance();
		t.method1(new Student());
		
		System.out.println();
		
		t.method1(new Graduate());
	}

	public void method1(Person p) {// Person p = new Student();
		System.out.println(p.getInfo());
		
		
		if (p instanceof Graduate) {
			System.out.println("a graduate");
		}

		if (p instanceof Student) {
			System.out.println("a student");
		}
		if (p instanceof Person) {
			System.out.println("a person");
		}
		
	}
}

class Person {
	protected String name = "person";
	protected int age = 50;

	public String getInfo() {
		return "Name: " + name + "\n" + "age: " + age;
	}
}

class Student extends Person {
	protected String school = "pku";

	public String getInfo() {
		return super.getInfo() + "\nschool: " + school;
	}
}

class Graduate extends Student {
	public String major = "IT";

	public String getInfo() {
		return super.getInfo() + "\nmajor:" + major;
	}
}
