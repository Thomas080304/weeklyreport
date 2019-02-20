/*
编写程序：由键盘输入三个整数分别存入变量num1、num2、num3，
对它们进行排序(使用 if-else if-else),并且从小到大输出。

说明：如果if-else if-else条件的执行语句块{}只有一条语句的话，那么这一对{}可以省略
建议：不要省略{}
*/
import java.util.Scanner;
class TestIf3{
	public static void main(String[] args) {
		//1.从键盘获取三个整数
		Scanner s = new Scanner(System.in);
		System.out.println("请输入第一个整数：");
		int num1 = s.nextInt();
		System.out.println("请输入第二个整数：");
		int num2 = s.nextInt();
		System.out.println("请输入第三个整数：");
		int num3 = s.nextInt();

		//2.对num1，num2，num3从小到大排序
		System.out.println("从小到大的排序为：");
		if(num1 > num2){
			if(num3 > num1)
				System.out.println(num2 + "," + num1 + "," + num3);
			//System.out.println("helloworld");
			else if(num3 < num2)
				System.out.println(num3 + "," + num2 + "," + num1);
			else
				System.out.println(num2 + "," + num3 + "," + num1);
			
		}else{
			if(num3 > num2)
				System.out.println(num1 + "," + num2 + "," + num3);
			else if(num3 < num1)
				System.out.println(num3 + "," + num1 + "," + num2);
			else
				System.out.println(num1 + "," + num3 + "," + num2);
			
		}
	
	}
}
