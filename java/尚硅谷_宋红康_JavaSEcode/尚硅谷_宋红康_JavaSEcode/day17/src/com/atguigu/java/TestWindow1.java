package com.atguigu.java;

//使用实现Runnable接口的方式，售票
/*
 * 此程序存在线程的安全问题：打印车票时，会出现重票、错票
 */

class Window1 implements Runnable {
	int ticket = 100;

	public void run() {
		while (true) {
			if (ticket > 0) {
//				try {
//					Thread.currentThread().sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				System.out.println(Thread.currentThread().getName() + "售票，票号为："
						+ ticket--);
			} else {
				break;
			}
		}
	}
}

public class TestWindow1 {
	public static void main(String[] args) {
		Window1 w = new Window1();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
