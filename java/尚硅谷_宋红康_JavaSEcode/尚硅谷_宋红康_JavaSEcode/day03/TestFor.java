/*
for循环结构：
1.格式：
①初始化条件
②循环条件
③迭代条件
④循环体
for(①;②;③){
	//④
}
2.执行过程：①-②-④-③-②-④-③-。。。-④-③-②
   即直至循环条件不满足，退出当前的循环
*/
class TestFor{
	public static void main(String[] args) {

		System.out.println("Hello World!" );
		System.out.println("Hello World!" );
		System.out.println("Hello World!" );
		System.out.println("Hello World!" );
		
		System.out.println();

		for(int i = 0;i < 4;i++){
			System.out.println("Hello World!" );
		}
		//System.out.println(i);
		int j = 1;
		for(System.out.print('a');j < 3;System.out.print('b'),j++){
			System.out.print('c');
		}
		//acbcb
		System.out.println();
		//题目：输出100以内的所有偶数及所有偶数的和（累加的思想）及偶数的个数
		int sum = 0;//用来记录所有偶数的和
		int count = 0;
		for(int i = 1;i <= 100;i++){//100以内的自然数的遍历
			if(i % 2 == 0){
				System.out.println(i);
				sum += i;
				count++;
			}
		}
		System.out.println("总和为：" + sum);
		System.out.println("100以内偶数的个数为：" + count);
	}
}
