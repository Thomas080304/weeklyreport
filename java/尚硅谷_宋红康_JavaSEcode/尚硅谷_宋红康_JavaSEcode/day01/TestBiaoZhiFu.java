/*
标识符：凡是可以自己命名的地方，都叫标识符。如：类名、方法名、变量名、接口名，。。。

1.标识符命名的规则：(要求严格遵守，否则会报编译性的错误)
由26个英文字母大小写，0-9 ，_或 $ 组成  
数字不可以开头。
不可以使用关键字和保留字，但能包含关键字和保留字。
Java中严格区分大小写，长度无限制。
标识符不能包含空格。

2.Java中的名称命名规范：(如果不遵守，也不会报错)
包名：多单词组成时所有字母都小写：xxxyyyzzz
类名、接口名：多单词组成时，所有单词的首字母大写：XxxYyyZzz
变量名、方法名：多单词组成时，第一个单词首字母小写，第二个单词开始每个单词首字母大写：xxxYyyZzz
常量名：所有字母都大写。多单词时每个单词用下划线连接：XXX_YYY_ZZZ

*/

class TestBiaoZhiFu 
{
	public static void main(String[] args) 
	{
		int static1 = 1;
		int myInt = 12;
		System.out.println("Hello World!");
	}

	public void add(){
	
	}
	//注意：在起名字时，为了提高阅读性，要尽量有意义，“见名知意”。
	public void m1(){}
	public void m2(){}
}

//class 3Hello
class Static{
}

