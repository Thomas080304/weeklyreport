/*
①初始化条件
②循环条件
③迭代条件
④循环体

1.格式：
①
do{
	④
	③
}while(②);

2.do-while与while的区别:do-while循环至少会执行一次！
*/

class TestDoWhile{
	public static void main(String[] args) {
		int i = 1;
		do{
			if(i % 2 == 0){
				System.out.println(i);
			}
			i++;
		}while(i <= 100);
		
		
		//do-while与while的区别
		int j = 10;
		do{
			System.out.println(j);
			j++;
		}while(j < 10);


		while(j < 10){
			System.out.println(j);
			j++;
		}
	}
}
