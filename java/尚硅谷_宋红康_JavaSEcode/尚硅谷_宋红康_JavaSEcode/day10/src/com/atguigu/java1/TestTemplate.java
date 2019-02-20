package com.atguigu.java1;

//模板方法设计模式
public class TestTemplate {
	public static void main(String[] args) {
		new SubTemplate().spendTime();
	}
}

abstract class Template {

	public abstract void code();

	public void spendTime() {
		long start = System.currentTimeMillis();

		this.code();

		long end = System.currentTimeMillis();
		System.out.println("花费的时间为：" + (end - start));
	}
}

class SubTemplate extends Template {
	
	public void code() {
		boolean flag = false;
		for(int i = 2;i <= 10000;i++){
			for(int j = 2;j <= Math.sqrt(i);j++){
				if(i % j == 0){
					flag = true;
					break;
				}
			}
			if(!flag){
				System.out.println(i);
			}
			flag = false;
		}
	}
}