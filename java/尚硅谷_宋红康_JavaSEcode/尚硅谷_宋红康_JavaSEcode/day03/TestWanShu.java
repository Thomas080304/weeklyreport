/*
一个数如果恰好等于它的因子之和，这个数就称为"完数"。（因子：除去这个数本身正的约数）
例如6=1＋2＋3.编程 找出1000以内的所有完数
*/
class TestWanShu{
	public static void main(String[] args){
		int factor = 0;
		for(int i = 1;i <= 1000;i++){
			//每执行完一次如下的循环，就会将i的所有的因子累加到factor中
			for(int j = 1;j < i;j++){
				if(i % j == 0){
					factor += j;
				}
			}
			if(i == factor){
				System.out.println(i);
			}
			factor = 0;
		}
	}
}
