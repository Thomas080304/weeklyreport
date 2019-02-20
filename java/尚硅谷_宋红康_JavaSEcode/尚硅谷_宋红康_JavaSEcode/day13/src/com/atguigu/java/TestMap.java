package com.atguigu.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/*
 * Collection接口
 * 
 * Map接口
 * 		|-----HashMap:Map的主要实现类
 * 		|-----LinkedHashMap:使用链表维护添加进Map中的顺序。故遍历Map时，是按添加的顺序遍历的。
 * 		|-----TreeMap:按照添加进Map中的元素的key的指定属性进行排序。要求：key必须是同一个类的对象！
 * 				针对key：自然排序   vs 定制排序
 * 		|-----Hashtable:古老的实现类，线程安全，不建议使用。
 * 			|----Properties:常用来处理属性文件。键和值都为String类型的
 */
public class TestMap {
	//使用Properties处理属性文件
	@Test
	public void test6() throws FileNotFoundException, IOException{
		Properties pros = new Properties();
		pros.load(new FileInputStream(new File("jdbc.properties")));
		String user = pros.getProperty("user");
		System.out.println(user);
		String password = pros.getProperty("password");
		System.out.println(password);
	}
	
	// 定制排序
	@Test
	public void test5() {
		Comparator com = new Comparator() {
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Customer && o2 instanceof Customer) {
					Customer c1 = (Customer) o1;
					Customer c2 = (Customer) o2;
					int i = c1.getId().compareTo(c2.getId());
					if (i == 0) {
						return c1.getName().compareTo(c2.getName());
					}
					return i;
				}
				return 0;
			}
		};
		TreeMap map = new TreeMap(com);
		map.put(new Customer("AA", 1001), 87);
		map.put(new Customer("CC", 1001), 67);
		map.put(new Customer("MM", 1004), 77);
		map.put(new Customer("GG", 1002), 97);
		
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + "----->" + map.get(obj));
		}
	}

	// 自然排序
	@Test
	public void test4() {
		Map map = new TreeMap();
		map.put(new Person("AA", 23), 89);
		map.put(new Person("MM", 22), 79);
		map.put(new Person("GG", 23), 99);
		map.put(new Person("JJ", 13), 69);

		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + "----->" + map.get(obj));
		}
	}

	@Test
	public void test3() {
		Map map = new LinkedHashMap();
		map.put("AA", 213);
		map.put("BB", 45);
		map.put(123, "CC");
		map.put(null, null);
		map.put(new Person("DD", 23), 89);

		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + "----->" + map.get(obj));
		}
	}

	/*
	 * 如何遍历Map Set keySet() Collection values() Set entrySet()
	 */
	@Test
	public void test2() {
		Map map = new HashMap();
		map.put("AA", 213);
		map.put("BB", 45);
		map.put(123, "CC");
		map.put(null, null);
		map.put(new Person("DD", 23), 89);

		// 1.遍历key集。
		Set set = map.keySet();
		for (Object obj : set) {
			System.out.println(obj);
		}
		// 2.遍历value集
		Collection values = map.values();
		Iterator i = values.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		// 3.如何遍历key-value对。
		// 方式一：
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + "----->" + map.get(obj));
		}
		// 方式二：
		Set set2 = map.entrySet();
		for (Object obj : set2) {
			Map.Entry entry = (Map.Entry) obj;
			// System.out.println(entry.getKey() + "---->" + entry.getValue());
			System.out.println(entry);
		}
	}

	/*
	 * Object put(Object key,Object value):向Map中添加一个元素 Object remove(Object
	 * key):按照指定的key删除此key-value void putAll(Map t) void clear():清空 Object
	 * get(Object key)：获取指定key的value值。若无此key，则返回null boolean containsKey(Object
	 * key) boolean containsValue(Object value) int size():返回集合的长度 boolean
	 * isEmpty() boolean equals(Object obj)
	 * 
	 * HashMap： 1.key是用Set来存放的，不可重复。value是用Collection来存放的，可重复
	 * 一个key-value对，是一个Entry。所有的Entry是用Set存放的，也是不可重复的。
	 * 2.向HashMap中添加元素时，会调用key所在类的equals()方法，判断两个key是否相同。若相同 则只能添加进后添加的那个元素。
	 */
	
	
	@Test
	public void test1() {
		Map map = new HashMap();
		map.put("AA", 213);
		map.put("BB", 456);
		map.put("BB", 45);
		map.put(123, "CC");
		map.put(null, null);
		map.put(new Person("DD", 23), 89);
		map.put(new Person("DD", 23), 87);
		System.out.println(map.size());
		System.out.println(map);
		map.remove("BB");
		System.out.println(map);
		Object value = map.get(1234);
		System.out.println(value);
	}
}
