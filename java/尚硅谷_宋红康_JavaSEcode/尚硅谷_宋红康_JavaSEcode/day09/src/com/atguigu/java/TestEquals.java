package com.atguigu.java;

public class TestEquals {
	public static void main(String[] args) {
		Person p1 = new Person("AA",12);
		Person p2 = new Person("AA",12);
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		
		
		//关于String类
		String str1 = "AA";
		String str2 = "AA";
		String str3 = new String("AA");
		System.out.println(str1 == str2);//true
		System.out.println(str1.equals(str2));//true
		System.out.println(str1 == str3);//false
		System.out.println(str1.equals(str3));//true
		System.out.println(p1.name == p2.name);//true
		
	}
}

class Person{
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//自定义一个实现Object类的equals()方法
//	public boolean equals(Object obj){
//		if(this == obj){
//			return true;
//		}
//		if(obj instanceof Person){
//			Person p = (Person)obj;
////			if(this.name == p.name && this.age == p.age){
////				return true;
////			}else{
////				return false;
////			}
//			return this.name.equals(p.name) && this.age == p.age;
//		}else{
//			return false;
//		}
//	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
//手动实现
//	public String toString() {
//		return "Person:name=" + name + " age=" + age;
//	}
	//自动调用
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
