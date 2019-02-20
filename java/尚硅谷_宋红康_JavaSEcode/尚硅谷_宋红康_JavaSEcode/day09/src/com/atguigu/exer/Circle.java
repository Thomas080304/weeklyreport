package com.atguigu.exer;

public class Circle extends GeometricObject{
	private double radius;

	public Circle(){
//		this.color = "white";
//		this.weight = 1.0;
		this.radius = 1.0;
	}
	public Circle(double radius){
		this.radius = radius;
	}
	public Circle(double radius,String color,double weight){
		super(color,weight);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	//计算圆的面积
	public double findArea(){
		return 3.14 * radius * radius;
	}
//	//重写equals()方法和toString()
//	public boolean equals(Object obj){
//		if(obj == this)
//			return true;
//		else if(obj instanceof Circle){
//			Circle c1 = (Circle)obj;
//			return this.radius == c1.radius;
//		}else{
//			return false;
//		}
//	}
//	public String toString(){
//		//return radius + "";
//		return String.valueOf(radius);
//	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(radius) != Double
				.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
}
