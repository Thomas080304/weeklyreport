package com.atguigu.java1;
//static的一个应用:使用静态的变量可以实现“累加”的效果。因为静态的变量在内存中独一份！
public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle(2.0);
		Circle c2 = new Circle(2.1);
		System.out.println(Circle.getTotal());
		Circle.show();
		c1.setInfo("我是一个漂亮的圆");
		Circle.show();
	}
}
class Circle{
	private double radius;//半径
	private static String info = "我是一个圆";
	private static int total = 0;//因为total是static的，在内存中独一份，所以可以用来记录创建的对象的个数
	
	public Circle(double radius){
		this.radius = radius;
		total++;
	}
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public static String getInfo() {
		return info;
	}

	public static void setInfo(String info) {
		Circle.info = info;
	}

	public static int getTotal() {
		return total;
	}

	public static void show(){
		System.out.println(info);
	}
	
	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
		
	}
	
}