package com.luke.algorithm.sorting;

import java.util.Arrays;

import static sun.misc.Version.println;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000);
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr));
		long before = System.currentTimeMillis();
		insertSort(arr);
		long end = System.currentTimeMillis();
		System.out.printf("耗时为%d毫秒", end - before);
	}

	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int insertIndex = i - 1;
			int insertValue = arr[i];

			while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex]; //把值后移
				insertIndex--;
			}

			arr[insertIndex+1] = insertValue;

//			System.out.printf("第%d次排序后\t\n", i);
//			System.out.println(Arrays.toString(arr));
		}

	}
}
