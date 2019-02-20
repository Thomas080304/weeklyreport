/*
1.格式：三种
2.执行if-else语句时，一定会选择其中的一个路径执行，而且也仅会选择一条路径。
*/
class TestIf1 {
	public static void main(String[] args){
		int age = 28;

		if(age > 18){
			System.out.println("你已经成年了！");
		}else{
			System.out.println("你还不能看成人电影！");
		}

		if(age > 130 || age < 0){
			System.out.println("你估计不是人");
		}else if(age < 30){
			System.out.println("人家还很年轻，只有" + age + "岁的啦~~么么");
		}else{
			System.out.println("别追我了，我都有两个娃了！");
		}

		if(age < 30){
			//1.
		}else if(age < 60){
			//2.
		}else if(age < 100){
			//3.
		}else{
			//4.
		}

	}
}
