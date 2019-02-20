package com.atguigu.exer;

import java.util.Scanner;
import java.util.Vector;

/*
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
	提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。
	而向量类java.util.Vector可以根据需要动态伸缩。
	创建Vector对象：Vector v=new Vector();
	给向量添加元素：v.addElement(obj);   //obj必须是对象
	取出向量中的元素：Object  obj=v.elementAt(0);
	注意第一个元素的下标是0，返回值是Object类型的。
	计算向量的长度：v.size();
	若与最高分相差10分内：A等；20分内：B等；
	      30分内：C等；其它：D等
 */
public class TestScore {
	public static void main(String[] args) {
		//1.创建Scanner的对象，提示从键盘输入学生的成绩（以负数代表输入结束）
		Scanner s = new Scanner(System.in);
		System.out.println("请输入学生的成绩：（以负数代表输入结束）");
		//2.for(;;),从键盘依次获取学生的成绩，并填入由Vector v=new Vector()创建的对象v中。
		Vector v=new Vector();
		int maxScore = 0;//记录最高分
		for(;;){
			int score = s.nextInt();
			if(score < 0){
				break;
			}
			//3.求出所有输入的正的成绩中的最高分
			//获取学生成绩中的最高分
			if(maxScore < score){
				maxScore = score;
			}
			//依次将学生成绩村放入v中
			Integer score1 = new Integer(score);
			v.addElement(score1);
		}
		
		//4.通过v.elementAt(i)依次获取填入v中的元素，同时判断一下各个分数的等级并输出。
		for(int i = 0;i < v.size();i++){
			Integer score = (Integer)v.elementAt(i);
			char level;
			if(maxScore - score <= 10){
				level = 'A';
			}else if(maxScore - score <= 20){
				level = 'B';
			}else if(maxScore - score <= 30){
				level = 'C';
			}else{
				level = 'D';
			}
			System.out.println("学生成绩为：" + score + ",等级为：" + level);
		}
	}
}
