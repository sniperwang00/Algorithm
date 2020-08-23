package com.luke.algorithm.sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
//		int[] arr = new int[]{119, 34, 1, 101};
//		System.out.println(Arrays.toString(arr));
//
//		sort(arr);
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 800000);
		}
//		System.out.println(Arrays.toString(arr));
		long before = System.currentTimeMillis();
		sort(arr);
		long end = System.currentTimeMillis();
		System.out.printf("耗时为%d毫秒", end - before);

	}

	public static int[] sort(int[] arr){

		for(int j=0; j<arr.length-1;j++){
			int min=arr[j];
			int pointer = j;

			for (int i = j + 1; i < arr.length; i++) {
				if(arr[i]<min){
					min = arr[i];
					pointer = i;
				}
			}
			arr[pointer] = arr[j];
			arr[j] = min;
//			System.out.println(Arrays.toString(arr));
		}

//		int min = arr[0];
//		int pointer = 0;
//		for(int i=1; i<arr.length; i++){
//			if(arr[i]<min){
//				min = arr[i];
//				pointer = i;
//			}
//		}
//		arr[pointer] = arr[0];
//		arr[0] = min;
//		System.out.println(Arrays.toString(arr));
//
//		min = arr[1];
//		pointer = 1;
//		for(int i=2; i<arr.length; i++){
//			if(arr[i]<min){
//				min = arr[i];
//				pointer = i;
//			}
//		}
//		arr[pointer] = arr[1];
//		arr[1] = min;
//		System.out.println(Arrays.toString(arr));
//
//		min = arr[2];
//		pointer = 2;
//		for(int i=3; i<arr.length; i++){
//			if(arr[i]<min){
//				min = arr[i];
//				pointer = i;
//			}
//		}
//		arr[pointer] = arr[2];
//		arr[2] = min;
//		System.out.println(Arrays.toString(arr));

		return arr;
	}
}
