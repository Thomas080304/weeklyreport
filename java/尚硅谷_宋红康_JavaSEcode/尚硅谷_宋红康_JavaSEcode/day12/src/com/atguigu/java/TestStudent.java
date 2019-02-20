package com.atguigu.java;

public class TestStudent {
	public static void main(String[] args) {
		Student s = new Student();
		try {
			s.regist(-12);
			System.out.println(s);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
}

class Student {
	int id;

	public void regist(int id) throws MyException {
		if (id > 0) {
			this.id = id;
		} else {
			throw new MyException("传入的学号有误！");
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}

}