package com.atguigu.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * 泛型的使用
 * 1.在集合中使用泛型(掌握)
 * 2.自定义泛型类、泛型接口、泛型方法（理解 --->使用）
 * 3.泛型与继承的关系
 * 4.通配符
 * 
 */
public class TestGeneric {
	/*
	 * 通配符的使用
	 */
	@Test
	public void test7(){
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("BB");
		List<?> list1 = list;
		//可以读取声明为通配符的集合类的对象
		Iterator<?> iterator = list1.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//不允许向声明为通配符的集合类中写入对象。唯一例外的是null
//		list1.add("CC");
//		list1.add(123);
		list1.add(null);
	}
	/*
	 * 通配符 ?
	 * List<A>、List<B>、。。。。都是List<?>的子类
	 * 
	 * ? extends A :可以存放A及其子类
	 * ? super A:可以存放A及其父类
	 */
	@Test
	public void test6(){
		List<?> list = null;
		List<Object> list1 = new ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		list = list1;
		list = list2;
		
		show(list1);
//		show(list2);
		show1(list1);
		show1(list2);
		
		List<? extends Number> list3 = null;
		List<Integer> list4 = null;
		list3 = list4;
//		list3 = list1;
		List<? super Number> list5 = null;
		list5 = list1;
	}
	
	public void show(List<Object> list){
		
	}
	public void show1(List<?> list){
		
	}
	/*
	 * 泛型与继承的关系:
	 * 若类A是类B的子类，那么List<A>就不是List<B>的子接口
	 */
	@Test
	public void test5(){
		Object obj = null;
		String str = "AA";
		obj = str;
		
		Object[] obj1 = null;
		String[] str1 = new String[]{"AA","BB","CC"};
		obj1 = str1;
		
		List<Object> list = null;
		List<String> list1 = new ArrayList<String>();
//		list = list1;
		//假设list = list1满足
		//list.add(123);
		//String str = list1.get(0);//出现问题，所以假设不满足
	}
	
	//自定义泛型类的使用
	@Test
	public void test4(){
		//1.当实例化泛型类的对象时，指明泛型的类型。
		//指明以后，对应的类中所有使用泛型的位置，都变为实例化中指定的泛型的类型
		//2.如果我们自定义了泛型类，但是在实例化时没有使用，那么默认类型是Object类的
		Order<Boolean> order = new Order<Boolean>();
//		order.getT();
		order.setT(true);
		System.out.println(order.getT());
		order.add();
		List<Boolean> list = order.list;
		System.out.println(list);
		
		SubOrder o = new SubOrder();
		List<Integer> list1 = o.list;
		System.out.println(list1);
		//当通过对象调泛型方法时，指明泛型方法的类型。
		Integer i = order.getE(34);
		Double d = order.getE(2.3);
		
		Integer[] in = new Integer[]{1,2,3};
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = order.fromArrayToList(in, list2);
		System.out.println(list3);
	}
	@Test
	public void test3(){
		Map<String,Integer> map = new HashMap<>();
		map.put("AA", 78);
		map.put("BB", 87);
		map.put("DD", 98);
		
		Set<Map.Entry<String,Integer>> set = map.entrySet();
		for(Map.Entry<String,Integer> o : set){
			System.out.println(o.getKey() + "--->" + o.getValue());
		}
	}
	
	//2.在集合中使用泛型
	@Test
	public void test2(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(78);
		list.add(87);
//		list.add("AA");
		
//		for(int i = 0;i < list.size();i++){
//			int score = list.get(i);
//			System.out.println(score);
//		}
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	//1.在集合中没有使用泛型的情况下
	@Test
	public void test1(){
		List list = new ArrayList();
		list.add(89);
		list.add(87);
		list.add(67);
		//1.没有使用泛型，任何Object及其子类的对象都可以添加进来
		list.add(new String("AA"));
		
		for(int i = 0;i < list.size();i++){
			//2.强转为int型时，可能报ClassCastException的异常
			int score = (Integer)list.get(i);
			System.out.println(score);
		}
	}
}
