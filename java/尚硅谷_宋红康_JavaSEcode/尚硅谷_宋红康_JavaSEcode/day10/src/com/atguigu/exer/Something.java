package com.atguigu.exer;

public class Something {
	public static void main(String[] args) {
		Other o = new Other();
		new Something().addOne(o);
	}

	public void addOne(final Other o) {
		//o = null;
		o.i++;

	}

	// public int addOne(final int x) {
	// //return ++x;
	//
	// return x;
	// }
}

class Other {
	public int i;
}
