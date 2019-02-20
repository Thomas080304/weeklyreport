/*
嵌套循环：循环中还可以声明循环。相当于内层循环的整体充当外层循环的循环体
for(;;){
	for(;;){
		
	}
}

或者
while(){
	for(;;){}
}
*/

class TestForFor{
	
	public static void main(String[] args) {
		/*
		*****
		*****
		*****
		*****
		*/
		for(int j = 0;j < 4;j++){//外层循环控制行数
			for(int i = 0;i < 5;i++){//内层循环控制列数
				System.out.print("*");
			}
			System.out.println();
		}

		/*
		*
		**
		***
		****
		*/
		for(int j = 0;j < 4;j++){//外层循环控制行数
			for(int i = 0;i < j + 1;i++){//每行输出j + 1个
				System.out.print("*");
			}
			System.out.println();
		}
		/*
		*****
		****
		***
		**
		*
		*/
		for(int i = 0; i < 5;i++){
			for(int j = 0;j < 5-i;j++){//for(int j = i;j < 5;j++)
				System.out.print("*");
			}
			System.out.println();
		}

		/*
		*
		**
		***
		****
		*****
		****
		***
		**
		*
		*/
		for(int j = 0;j < 4;j++){//外层循环控制行数
			for(int i = 0;i < j + 1;i++){//每行输出j + 1个
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0; i < 5;i++){
			for(int j = 0;j < 5-i;j++){//for(int j = i;j < 5;j++)
				System.out.print("*");
			}
			System.out.println();
		}

/*
打印如下图形
----*
---* *
--* * *
-* * * *
* * * * *
i	k-	j*   k = 4 - i   j = i + 1
0	4	1
1	3	2
2	2	3
3	1	4
4	0	5
-* * * *
--* * *
---* *
----*
i	k-	j*   k = i + 1   j = 4 - i 
0	1	4	
1	2	3
2	3	2
3	4	1
*/	
	//上半部分：
	for(int i = 0;i < 5;i++){
		for(int k = 0;k < 4 - i;k++){
			System.out.print(" ");
		}
		for(int j = 0;j < i + 1;j++){
			System.out.print("* ");
		}
		System.out.println();
    }
	//下半部分
	for(int i = 0;i < 4;i++){
		for(int k = 0;k < i + 1;k++){
			System.out.print(" ");
		}
		for(int j = 0;j < 4 - i;j++){
			System.out.print("* ");
		}
		System.out.println();
	}
	}
}
