package com.atguigu.java1;

public class TestArray {
	public static void main(String[] args) {
		int[] arr = new int[]{12,4,76,0,-98,-54,4,100};
		
		int max = ArrayUtil.getMax(arr);
		System.out.println("最大值为：" + max);
		
		int avg = ArrayUtil.avg(arr);
		System.out.println("平均值为：" + avg);
		
		ArrayUtil.printArray(arr);
		
		System.out.println("反转数组：");
		ArrayUtil.reverse(arr);
		
		ArrayUtil.printArray(arr);
		
		System.out.println("对数组排序：");
		ArrayUtil.sort(arr,"asc");
		
		ArrayUtil.printArray(arr);
		
	}
}
