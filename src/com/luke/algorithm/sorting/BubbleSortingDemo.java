package com.luke.algorithm.sorting;

import java.util.Arrays;

public class BubbleSortingDemo {
	public static void main(String[] args) {
		/*int[] unsorted = new int[]{3, 9, -1, 10, 20};
		System.out.println(Arrays.toString(unsorted));

		int[] sorted = sort(unsorted);

		System.out.println(Arrays.toString(unsorted));*/

		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000);
		}
//		System.out.println(Arrays.toString(arr));
		long before = System.currentTimeMillis();
		sort(arr);
		long end = System.currentTimeMillis();
		System.out.printf("耗时为%d毫秒", end - before);
	}

	private static int[] sort(int[] unsorted) {
		boolean flag = false;
		for (int i=unsorted.length-2;i>=0;i--){
			for(int j=0; j<=i; j++){
				if(unsorted[j]>unsorted[j+1]){
					flag=true;
					int tmp = unsorted[j+1];
					unsorted[j+1] = unsorted[j];
					unsorted[j] = tmp;
				}
			}

			if(!flag){
				break;
			}else {
				flag = false;
			}
		}

		return unsorted;
	}
}
