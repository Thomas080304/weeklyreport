package com.atguigu.java;
//静态代理模式
//接口
interface ClothFactory{
	void productCloth();
}
//被代理类
class NikeClothFactory implements ClothFactory{

	@Override
	public void productCloth() {
		System.out.println("Nike工厂生产一批衣服");
	}	
}
//代理类
class ProxyFactory implements ClothFactory{
	ClothFactory cf;
	//创建代理类的对象时，实际传入一个被代理类的对象
	public ProxyFactory(ClothFactory cf){
		this.cf = cf;
	}
	
	@Override
	public void productCloth() {
		System.out.println("代理类开始执行，收代理费$1000");
		cf.productCloth();
	}
	
}

public class TestClothProduct {
	public static void main(String[] args) {
		NikeClothFactory nike = new NikeClothFactory();//创建被代理类的对象
		ProxyFactory proxy = new ProxyFactory(nike);//创建代理类的对象
		proxy.productCloth();
	}
}
