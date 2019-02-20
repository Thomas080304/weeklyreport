package com.atguigu.exer;

import java.util.Scanner;

/*
 * 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
 * 利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday,以及该对象生日。
 * 当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 */
public class PayrollSystem {
	public static void main(String[] args) {
		Employee[] emps = new Employee[2];
		emps[0] = new SalariedEmployee("李雷", 1001, new MyDate(1998, 12, 21),
				8800);

		emps[1] = new HourlyEmployee("韩梅梅", 1002, new MyDate(1987, 4, 30), 100,
				6);
		
		Scanner s = new Scanner(System.in);
		System.out.println("请输入本月的月份：");
		int month = s.nextInt();
		
		for(int i = 0;i < emps.length;i++){
			if(month == emps[i].getBirthday().getMonth()){
				System.out.println("加工资，加100！");
			}
			System.out.println(emps[i]);
		}

	}
}
