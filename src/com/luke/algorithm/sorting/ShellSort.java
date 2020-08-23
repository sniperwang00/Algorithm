package com.luke.algorithm.sorting;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
//		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//		shellSort(arr);
		int[] arr = new int[80];
		for (int i = 0; i < 80; i++) {
			arr[i] = (int) (Math.random() * 80000);
		}
//		System.out.println(Arrays.toString(arr));
		long before = System.currentTimeMillis();
		shellSort2(arr);
		long end = System.currentTimeMillis();
		System.out.printf("耗时为%d毫秒", end - before);

	}

	public static void shellSort(int[] arr) {
		//第一次排序
		int tmp = 0;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						tmp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = tmp;
					}
				}
			}
//			System.out.println(Arrays.toString(arr));
		}




		//第二次
//		for (int i = 2; i < arr.length; i++) {
//			for (int j = i - 2; j >= 0; j -= 2) {
//				if (arr[j] > arr[j + 2]) {
//					tmp = arr[j];
//					arr[j] = arr[j + 2];
//					arr[j + 2] = tmp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));
//
//		for (int i = 1; i < arr.length; i++) {
//			for (int j = i - 1; j >= 0; j -= 1) {
//				if (arr[j] > arr[j + 1]) {
//					tmp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = tmp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));

	}

	public static void shellSort2(int[] arr) {
		//第一次排序
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int tmp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && tmp < arr[j - gap]) {
						arr[j] = arr[j - gap];
						j -= gap;
					}
					arr[j] = tmp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
