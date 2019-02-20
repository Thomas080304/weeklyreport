package com.atguigu.review;

public class TestPerson {

}

class Person {
	String name;
	int id;// 身份证号

	public String show() {
		return "name:" + name + " id:" + id;
	}
	
	public Person() {
		super();
	}

	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
}

class Student extends Person {
	String major;
	int id;// 学号

	public Student() {
		// super.name = "AA";
		this.name = "AA";
		super.id = 1001;
		this.major = "IT";
		this.id = 1002;
	}
	

	public Student(String name,int id1,String major, int id2) {
		super(name,id1);
		this.major = major;
		this.id = id2;
	}


	public String show() {
		// return super.show() + "major:" + major + "id:" + id;
		return "name:" + super.name + "id:" + super.id + "major:" + major
				+ "id:" + id;
	}
}