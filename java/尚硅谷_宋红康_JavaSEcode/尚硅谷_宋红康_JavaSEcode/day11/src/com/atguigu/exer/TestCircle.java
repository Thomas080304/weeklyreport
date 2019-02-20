package com.atguigu.exer;

/*
 * 定义一个接口用来实现两个对象的比较。
 interface CompareObject{
 public int compareTo(Object o);   //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
 }
 定义一个Circle类。

 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。

 定义一个测试类TestCircle，创建两个ComparableCircle对象，
 调用compareTo方法比较两个类的半径大小。

 */
public class TestCircle {
	public static void main(String[] args) {
		ComparableCircle c1 = new ComparableCircle(2.3);
		ComparableCircle c2 = new ComparableCircle(2.1);
		ComparableCircle c3 = new ComparableCircle(2.3);
		
		int i1 = c1.compareTo(c2);
		int i2 = c1.compareTo(c3);
		int i3 = c2.compareTo(c1);
		System.out.println(i1);//1
		System.out.println(i2);//0
		System.out.println(i3);//-1
		int i4 = c1.compareTo(new String());
	}
}

interface CompareObject {
	int compareTo(Object o);
}

class Circle {
	private double radius;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}

class ComparableCircle extends Circle implements CompareObject {
	public ComparableCircle(double radius){
		super(radius);
	}
	@Override
	public int compareTo(Object o) {
		if (this == o) {
			return 0;
		} else if (o instanceof ComparableCircle) {
			ComparableCircle c = (ComparableCircle) o;
			if (this.getRadius() > c.getRadius()) {
				return 1;
			} else if (this.getRadius() < c.getRadius()) {
				return -1;
			} else {
				return 0;
			}
		} else {
			// return -2;
			throw new RuntimeException("传入的非ComparableCircle的对象，不可进行比较");
		}
	}

}