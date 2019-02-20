//逻辑运算符：  &  && | || ! ^
class TestLogic{
	public static void main(String[] args){
		boolean a = true;
		boolean b = false;

		System.out.println(a & b);
		System.out.println(a && b);
		System.out.println(a | b);
		System.out.println(a || b);
		System.out.println(a & !b);
		System.out.println(a^b);

		//& 与 && 的区别：&:不管左边是true还是false，右端都会进行运算。
		//				   &&:当左端为false时，右端不再进行运算
		//以后使用时，建议使用 &&
		int i1 = 10;
		if(b & (i1++) > 0){
			System.out.println("今天天气很晴朗");
		}else{
			System.out.println("难得没有雾霾");
		}
		System.out.println(i1);//11

		int i2 = 10;
		if(b && (i2++) > 0){
			System.out.println("今天天气很晴朗");
		}else{
			System.out.println("难得没有雾霾");
		}
		System.out.println(i2);//10


		//| 与 || 的区别：|：当左端为true时，右端照样做运算。
		// ||:当左端为true时，右端不再进行运算。
		//我们在使用时，选择：||
		int i3 = 10;
		if(a | i3++ > 0){
			System.out.println("今天天气很晴朗");
		}else{
			System.out.println("难得没有雾霾");
		}
		System.out.println(i3);//11

		int i4 = 10;
		if(a || i4++ > 0){
			System.out.println("今天天气很晴朗");
		}else{
			System.out.println("难得没有雾霾");
		}
		System.out.println(i4);//10

	}
}
