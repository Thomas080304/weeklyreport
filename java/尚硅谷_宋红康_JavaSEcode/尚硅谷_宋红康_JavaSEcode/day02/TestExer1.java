class TestExer1{
	public static void main(String[] args){
		int m = 12;
		int n = 5;
		System.out.println("m:" + m + " n:" + n);
		//方法一：提供一个临时变量。
		//int temp = m;
		//       m = n;
		//       n = temp;
		//System.out.println("m:" + m + " n:" + n);

		//方法二：当m和n较大时，有可能出现精度损失
		//m = m + n;//m = 12 + 5;
		//n = m - n;//n = 17 - 5;
		//m = m - n;//m = 17- 12
		//System.out.println("m:" + m + " n:" + n);

		//方法三：优点：没有上面两种方法的缺点。 缺点：难！
		m = m ^ n;
		n = m ^ n;//(m ^ n) ^ n == m
		m = m ^ n;//(m ^ n) ^ m == n
		System.out.println("m:" + m + " n:" + n);
		
		//问题：
		//60  手动的方式，从控制台输出60的十六进制。
		int i = 61;
		//自动调用Integer类现成的方法
		String binary = Integer.toBinaryString(i);
		
		System.out.println(binary);

		String hex = Integer.toHexString(i);
		System.out.println(hex);
		
		/*
		char c = 'a';
		char c1 = (char)(c + 2);
		System.out.println(c1);//c
		*/

		int j = i & 15;//获取到i的最低4位对应的值。
		String k1 = (j <= 9)? j + "" : (char)(j - 10 + 'a') + ""; 
		//System.out.println(k1);

		i = i >> 4;
		int z = i & 15;
		String k2 = (z <= 9)? z + "" : (char)(z - 10 + 'a') + "";
		
		System.out.println(k2 + k1);
	}
}
