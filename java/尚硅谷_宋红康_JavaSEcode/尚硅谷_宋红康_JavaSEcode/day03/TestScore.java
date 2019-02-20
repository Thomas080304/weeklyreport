/*
编写程序：从键盘上读入一个学生成绩，存放在变量score中，根据score的值输出其对应的成绩等级：

score>=90           等级：A
70<=score<90     等级: B
60=<score<70     等级: C
score<60             等级：D

*/
import java.util.Scanner;
class TestScore{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入学生的成绩：");
		int score = s.nextInt();
		char level;
		/*
		if(score >= 90){
			level = 'A';
		}else if(score >= 70){
			level = 'B';
		}else if(score >= 60){
			level = 'C';
		}else{
			level = 'D';
		}
		*/
		switch(score / 10){
			case 10:
			case 9:
				level = 'A';
				break;
			case 8:
			case 7:
				level = 'B';
				break;
			case 6:
				level = 'C';
				break;
			default:
				level = 'D';
				break;
		}

		System.out.println("score:" + score + ",level:" + level);
	}
}
