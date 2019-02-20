package com.atguigu.exer;

public class TestBoyGirl {
	public static void main(String[] args) {
		Boy boy = new Boy();
		boy.setName("工藤新一");
		boy.setAge(23);
		
		Girl girl = new Girl();
		girl.setName("小兰");
		
		boy.marry(girl);
		boy.shout();
		System.out.println();
		girl.marry(boy);
		
		
	}
}
