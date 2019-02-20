//测试算术运算符： + - + - * / % ++ -- +
class TestAri{
	public static void main(String[] args){
		
		// 除：/
		int i = 12;
		int j = i/5;
		double d = i / 5;
		double d1 = i/5.0;
		System.out.println(j);//2
		System.out.println(d);//2.0
		System.out.println(d1);//2.4
		//取模：%：取余数. 结果的符号取决于被模数
		int i1 = 12 % 5;
		int i2 = -12 % 5;
		int i3 = 12 % (-5);
		int i4 = -12 % (-5);
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		//前++:先自增1，后做运算
		//后++:先做运算，后自增1

		int myInt1 = 10;
		int myInt2 = myInt1++;//后++
		System.out.println(myInt1);//11
		System.out.println(myInt2);//10

		int myInt3 = 10;
		int myInt4 = ++myInt3;//前++
		System.out.println(myInt3);//11
		System.out.println(myInt4);//11

		//前--:先自减1，后做运算
		//后--:先做运算，后自减1

	}
}
