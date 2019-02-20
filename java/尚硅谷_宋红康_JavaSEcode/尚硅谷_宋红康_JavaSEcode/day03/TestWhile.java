/*
①初始化条件
②循环条件
③迭代条件
④循环体
1.格式：
①
while(②){
	④
	③
}
2.for循环与while可以相互转换。
*/
class TestWhile{
	public static void main(String[] args) {
		//100以内的偶数的输出,及其和
		int i = 1;
		int sum = 0;
		while(i <= 100){
			if(i % 2 == 0){
				System.out.println(i);
				sum += i;
			}
			i++;
	
		}
		System.out.println(sum);
		//System.out.println(i);
	}
}
