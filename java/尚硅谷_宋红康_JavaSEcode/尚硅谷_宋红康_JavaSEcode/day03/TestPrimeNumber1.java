
class TestPrimeNumber1{
	public static void main(String[] args){
		//boolean flag = false;
		long start = System.currentTimeMillis();//获取系统当前的毫秒数
		l:for(int i = 2;i <= 100000;i++){//实现100以内的自然数的遍历
			//如何判断i是否为一个质数
			for(int j = 2;j <= Math.sqrt(i);j++){
				if(i % j == 0){
					//flag = true;
					//break;
					continue l;
				}
			}
			//if(!flag){//if(flag == false){
				System.out.println(i);
			//}
			//flag = false;
		}
		long end = System.currentTimeMillis();
		System.out.println("所花费的时间为：" + (end - start));
		//35535--加上break：10059--使用Math.sqrt():
	}
}
