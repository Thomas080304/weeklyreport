package com.atguigu.java;

/*
 * 类的第四个成员：初始化块（或代码块）
 * 1.代码块如果有修饰的话，那么只能使用static。
 * 2.分类：
 * 静态代码块：
 * 1.里面可以有输出语句
 * 2.随着类的加载而加载，而且只被加载一次
 * 3.多个静态代码块之间按照顺序结构执行
 * 4.静态代码块的执行要早于非静态代码块的执行。
 * 5.静态的代码块中只能执行静态的结构(类属性，类方法)
 * 
 * 非静态代码块：
 * 1.可以对类的属性(静态的 & 非静态的)进行初始化操作，同时也可以调用本类声明的方法(静态的 & 非静态的)
 * 2.里面可以有输出语句
 * 3.一个类中可以有多个非静态的代码块，多个代码块之间按照顺序结构执行
 * 4.每创建一个类的对象，非静态代码块就加载一次。
 * 5.非静态代码块的执行要早于构造器
 * 
 * 关于属性赋值的操作：①默认的初始化②显式的初始化或代码块初始化(此处两个结构按照顺序执行) ③构造器中；④通过方法对对象的相应属性进行修改
 */
public class TestOrder {
	public static void main(String[] args) {
		Order o1 = new Order();
		System.out.println(o1);

		System.out.println();

		Order o2 = new Order();
		System.out.println(o2);
	}
}

class Order {

	private String orderName;
	private int orderId = 1001;
	private static String orderDesc;
	public Order() {
		super();
		System.out.println("我是Order类的空参的构造器");
	}
	//非静态的初始化块
	{
		orderId = 1002;
		orderName = "AA";
		System.out.println("我是非静态代码块1");
		orderDesc = "ORDER";
		show1();
		show2();
	}
	{
		orderId = 1003;
		System.out.println("我是非静态代码块2");
	}
	//静态的代码块
	static{
		System.out.println("静态代码块2");
		orderDesc = "我是一个Order";
//		orderId = 1000;
//		show1();
		show2();
	}
	static{
		System.out.println("静态代码块1");
	}

	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + "]";
	}
	public void show1(){
		
	}
	public static void show2(){
		
	}

}