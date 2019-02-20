package com.atguigu.java;
/*
 * 理解一：人开门
 * 面向过程：人 打开 门
 * 面向对象:
 * 人{
 * 	  打开(门){
 * 		门.开开();
 *   }	
 * }
 * 
 * 门{
 * 	开开(){
 *  }
 * }
 * 
 * 理解二：人把大象装进冰箱
 * 面向过程：1）打开冰箱2）把大象放进去 3)关闭冰箱门
 * 面向对象：
 * 人{
 * 	   打开(冰箱){冰箱.开开()}
 *   操作(大象){大象.进入(冰箱)}
 *   关闭(冰箱){冰箱.合上()}
 * }
 * 
 * 大象{
 * 	   进入(冰箱){}
 * }
 * 冰箱{
 * 	开开(){}
 *  合上(){}
 * }
 * 
 * 
 */
public class TestOOP {

}

class Person1{
	Food food;
}
class Food{
	
}

class Bank{
	Customer cust;
}
class Customer{
	
}
