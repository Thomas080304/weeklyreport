package com.atguigu.exer1;

public class TestCylinder {
	public static void main(String[] args) {
		Cylinder c = new Cylinder();
		
		double area = c.findVolume();
		System.out.println(area);
		
		c.setRadius(2.3);
		c.setLength(1.2);
		area = c.findVolume();
		System.out.println(area);
		
		c.findArea();//求圆柱的表面积
	}
}
