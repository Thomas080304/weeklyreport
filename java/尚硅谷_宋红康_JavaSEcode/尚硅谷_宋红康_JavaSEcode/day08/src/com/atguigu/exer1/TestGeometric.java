package com.atguigu.exer1;

public class TestGeometric {
	public static void main(String[] args) {
		TestGeometric t = new TestGeometric();
		
		Circle c1 = new Circle(2.3, "Green", 1.0);
		Circle c2 = new Circle(2.3, "Red", 1.0);
		
		MyRectangle m1 = new MyRectangle(2.3, 3.0, "blue", 2.0);
		t.displayGeometricObject(c2);
		
		
		boolean b = t.equalsArea(m1, c2);
		System.out.println(b);
	}
	
	//判断两个对象的面积是否相等
	public boolean equalsArea(GeometricObject o1,GeometricObject o2){
//		if(o1.findArea() == o2.findArea())
//			return true;
//		else 
//			return false;
		return o1.findArea() == o2.findArea();
	}
	public void displayGeometricObject(GeometricObject o){//GeometricObject o = new Circle(2.3, "Red", 1.0);
		System.out.println(o.findArea());
	}
}
