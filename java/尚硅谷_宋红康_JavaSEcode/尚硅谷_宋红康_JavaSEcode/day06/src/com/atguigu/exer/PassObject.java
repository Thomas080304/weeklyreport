package com.atguigu.exer;
/*
 * （1）定义一个Circle类，包含一个double型的radius属性代表圆的半径，
 * 一个findArea()方法返回圆的面积。
（2）定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下：
		public void printAreas(Cirlce c, int time)
在printAreas方法中打印输出1到time之间的每个整数半径值，以及对应的面积。
例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积。
在main方法中调用printAreas()方法，调用完毕后输出当前半径值。


1.匿名类对象:创建的类的对象是匿名的。
    1）当我们只需要一次调用类的对象时，我们就可以考虑使用匿名的方式创建类的对象。
    2）特点：创建的匿名类的对象只能够调用一次！
 */
class Circle{
	double radius;
	
	public double findArea(){
		return Math.PI * radius * radius;
		//return Math.PI * getRadius() * getRadius();
	}
	
	public void setRadius(double r){
		radius = r;
	}
	public double getRadius(){
		return radius;
	}
	public void show(){
		System.out.println("我是一个圆");
	}
}

public class PassObject {
	public void printAreas(Circle c, int time){
		System.out.println("Radius" + "\t\t" + "Area");
//		int temp = 0;
//		for(int i = 1;i <= time;i++,temp = i){
//			c.setRadius(i);
//			System.out.println(c.getRadius() + "\t\t" + c.findArea());
//		}
		//c.setRadius(temp);
		int i = 1;
		while(i <= time){
			c.setRadius(i);
			System.out.println(c.getRadius() + "\t\t" + c.findArea());
			i++;
		}
		c.setRadius(i);
	}
	public static void main(String[] args) {
		PassObject p = new PassObject();
		Circle c = new Circle();//此时c的半径为0
		p.printAreas(c, 5);
		
		System.out.println("now radius is " + c.getRadius());
		System.out.println();
		
		p.printAreas(new Circle(), 6);
		//System.out.println("now radius is " + c.getRadius());
		
		
		new Circle().show();
		
		new Circle().setRadius(2.3);
		
		
	}
}
