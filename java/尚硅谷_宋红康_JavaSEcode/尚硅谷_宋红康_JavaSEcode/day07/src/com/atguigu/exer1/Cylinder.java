package com.atguigu.exer1;

public class Cylinder extends Circle {
	private double length;// 圆柱的高

	public Cylinder() {
		length = 1;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	// 重写父类Circle的方法，求圆柱的表面积
	public double findArea() {
		// return 3.14 * this.getRadius() * this.getRadius() * 2 + 2 * 3.14
		// * this.getRadius() * this.length;
		return super.findArea() * 2 + 2 * 3.14 * this.getRadius() * this.length;
	}

	// 圆柱的体积
	public double findVolume() {
		//return Math.PI * this.getRadius() * this.getRadius() * length;
		 return super.findArea() * length;
	}

}
