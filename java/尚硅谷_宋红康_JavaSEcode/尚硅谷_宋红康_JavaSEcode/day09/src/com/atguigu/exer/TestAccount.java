package com.atguigu.exer;
/*
 * 编写一个类实现银行账户的概念，包含的属性有“帐号”、“密码”、“存款余额”、“利率”、“最小余额”，定义封装这些属性的方法。账号要自动生成。
编写主类，使用银行账户类，输入、输出3个储户的上述信息。
考虑：哪些属性可以设计成static属性。

 */
public class TestAccount {
	public static void main(String[] args) {
		Account a1 = new Account("abc123",1000);
		Account a2 = new Account("abc456",2000);
		Account a3 = new Account("abc456",2000);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
	}
}
class Account{
	private int id;//账号
	private String password;//密码
	private double balance;//余额
	private static double rate = 0.05;//利率
	private static double minBalance = 1;//最小余额
	private static int init = 1000;
	
	public Account(String password,double balance){
		this.id = init++;
		this.password = password;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public static double getRate() {
		return rate;
	}
	public static void setRate(double rate) {
		Account.rate = rate;
	}
	public static double getMinBalance() {
		return minBalance;
	}
	public static void setMinBalance(double minBalance) {
		Account.minBalance = minBalance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", password=" + password + ", balance="
				+ balance + "]";
	}
	
	
}
