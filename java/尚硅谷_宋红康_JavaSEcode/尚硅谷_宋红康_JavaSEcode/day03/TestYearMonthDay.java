//从键盘分别输入年、月、日，判断这一天是当年的第几天
import java.util.Scanner;
class TestYearMonthDay{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = s.nextInt();
		System.out.println("请输入月份：");
		int month = s.nextInt();
		System.out.println("请输入日期：");
		int day = s.nextInt();

		int sum = 0;//用来记录year年month月day日是year年第几天
		//使用switch-case
		switch(month){
		
		case 12:
			sum += 30;//30:十一月份的总天数
		case 11:
			sum += 31;
		case 10:
			sum += 30;
		case 9:
			sum += 31;
		case 8:
			sum += 31;
		case 7:
			sum += 30;
		case 6:
			sum += 31;
		case 5:
			sum += 30;
		case 4:
			sum += 31;
		case 3:
			if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
				sum += 29;
			}else{
				sum += 28;
			}
		case 2:
			sum += 31;//31:是一月份的天数
		case 1:
			sum += day;
	
		}
		System.out.println(sum);
	}
}