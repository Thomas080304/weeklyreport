//1.导包
import java.util.Scanner;
class TestScanner{
	public static void main(String[] args){
		//2.创建一个Scanner类的对象
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		//3.调用此对象的相应的方法，完成键盘输入的值的获取
		//next():表示从键盘获取一个字符串
		String str = s.next();
		
		System.out.println(str);
	}
}
