/*
打印如下图形
----*
---* *
--* * *
-* * * *
* * * * *
i	j	k
0	4	1     j = 4-i;  k = i+1;
1	3	2
2	2	3
3	1	4
4	0	5
 * * * *
  * * *
   * *
    *
*/
class TestExer1
{
	public static void main(String[] args) 
	{
		for(int i = 0;i < 5;i++){
			//输出“-”
			for(int j = 0;j < 4-i;j++){
				System.out.print("-");
			}

			//输出“* ”
			for(int k = 0;k < i+1;k++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
