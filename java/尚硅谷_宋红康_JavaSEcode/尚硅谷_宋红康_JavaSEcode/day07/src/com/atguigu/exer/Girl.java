package com.atguigu.exer;

public class Girl {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void marry(Boy boy){
		System.out.println("ÎÒÒª¼Þ¸ø" + boy.getName());
		boy.marry(this);
	}
}
