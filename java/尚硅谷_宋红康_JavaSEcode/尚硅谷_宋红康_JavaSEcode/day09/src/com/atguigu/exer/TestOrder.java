package com.atguigu.exer;

/*
 * 编写Order类，有int型的orderId，String型的OrderName，
 * 相应的getter()和setter()方法，两个参数的构造器，重写父类的equals()方法：
 * public boolean equals(Object obj)，并判断测试类中创建的两个对象是否相等。

 */
public class TestOrder {
	public static void main(String[] args) {
		Order o1 = new Order(1001, "AA");
		Order o2 = new Order(1001, "AA");
		System.out.println(o1 == o2);// false
		System.out.println(o1.equals(o2));// false --->true
	}
}

class Order {
	private int orderId;
	private String orderName;

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
	//比较两个Order对象的属性是否完全相同。相同的话，返回true。
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		} else if (obj instanceof Order) {
//			Order o1 = (Order) obj;
//			return this.orderId == o1.orderId
//					&& this.orderName.equals(o1.orderName);
//		} else {
//			return false;
//		}
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		if (orderName == null) {
			if (other.orderName != null)
				return false;
		} else if (!orderName.equals(other.orderName))
			return false;
		return true;
	}
	
}
