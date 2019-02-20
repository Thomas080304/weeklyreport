package com.atguigu.exer;
//利用面向对象的编程方法，设计类Circle计算圆的面积。
public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		c1.radius = 2.3;
		//c1.findArea();
		double area = c1.findArea();
		System.out.println(area);
		
		c1.setRadius(4.5);//c1.radius = 4.5;
		System.out.println(c1.findArea());
	}
}
class Circle{
	double radius = 1.0;//半径
	
	//提供方法，用于获取圆的面积
//	public void findArea(){
//		//此处的radius为调用findArea()方法的对象的属性radius
//		System.out.println(3.14 * radius * radius);
//	}
	
	public double findArea(){
		return 3.14 * radius * radius;
	}
	//返回圆的半径
	public double getRadius(){
		return radius;
	}
	//设置圆的半径
	public void setRadius(double r){
		radius = r;
	}
}