package com.atguigu.exer;

/*
 * （1）	创建一个Customer ，名字叫 Jane Smith, 
 * 他有一个账号为1000，余额为2000元，年利率为 1.23％ 的账户。
 （2）	对Jane Smith操作。
 存入 100 元，再取出960元。再取出2000元。
 打印出Jane Smith 的基本信息
 Customer [Smith, Jane] has a account: id is 1000, 
 annualInterestRate is 1.23％, balance is 1140.0
 */
public class TestCustomer {
	public static void main(String[] args) {
		Customer cust = new Customer("Jane", "Smith");
		cust.setAccount(new Account(1000, 2000, 0.0123));
		Account account = cust.getAccount();
		account.deposit(100);
		account.withdraw(960);
		account.withdraw(2000);

		System.out.println("Customer [" + cust.getLastName() + ","
				+ cust.getFirstName() + "] has a account: id is"
				+ account.getId() + ",annualInterestRate is"
				+ account.getAnnualInterestRate() * 100 + "%,balance is"
				+ account.getBalance());

	}
}
