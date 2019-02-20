package com.atguigu.exer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

/*
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
分别按以下两种方式对集合中的元素进行排序，并遍历输出：

1). 使Employee 实现 Comparable 接口，并按 name 排序
2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。

提示：Employee类是否需要重写equals()方法？MyDate类呢？

 */
public class TestEmployee {
	//定制排序：创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
	@Test
	public void test2(){
		Comparator com = new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Employee1 && o2 instanceof Employee1){
					Employee1 e1 = (Employee1)o1;
					Employee1 e2 = (Employee1)o2;
					MyDate birth1 = e1.getBirthday();
					MyDate birth2 = e2.getBirthday();
					if(birth1.getYear() != birth2.getYear()){
						return birth1.getYear() - birth2.getYear();
					}else{
						if(birth1.getMonth() != birth2.getMonth()){
							return birth1.getMonth() - birth2.getMonth();
						}else{
							return birth1.getDay() - birth2.getDay();
						}
					}
				}
				return 0;
			}
			
		};
		TreeSet<Employee1> set = new TreeSet<>(com);
		Employee1 e1 = new Employee1("刘德华", 55, new MyDate(4, 12, 1976));
		Employee1 e2 = new Employee1("郭富城", 43, new MyDate(7, 3, 1954));
		Employee1 e3 = new Employee1("张学友", 33, new MyDate(9, 12, 1954));
		Employee1 e4 = new Employee1("黎明", 54, new MyDate(12, 3, 1954));
		Employee1 e5 = new Employee1("李敏镐", 65, new MyDate(4, 21, 1945));
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		Iterator<Employee1> i = set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}
	
	//自然排序： 使Employee 实现 Comparable 接口，并按 name 排序
	@Test
	public void test1(){
		Employee e1 = new Employee("刘德华", 55, new MyDate(4, 12, 1976));
		Employee e2 = new Employee("郭富城", 43, new MyDate(7, 3, 1965));
		Employee e3 = new Employee("张学友", 33, new MyDate(9, 12, 1954));
		Employee e4 = new Employee("黎明", 54, new MyDate(12, 2, 1967));
		Employee e5 = new Employee("李敏镐", 65, new MyDate(4, 21, 1945));
//		Employee e6 = new Employee("李敏镐", 63, new MyDate(4, 21, 1945));
		TreeSet<Employee> set = new TreeSet<>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
//		set.add(e6);
		
		Iterator<Employee> i = set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
