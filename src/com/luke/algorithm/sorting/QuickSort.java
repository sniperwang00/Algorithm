package com.luke.algorithm.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {3, 9, 1, 7, 2, 8, 5, 4, 6, 0};
//		int[] arr = new int[20];
//		for (int i = 0; i < 20; i++) {
//			arr[i] = (int) (Math.random() * 80000);
//		}
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int l = left;
			int r = right;
			int pivot = arr[left];

			while (l < r) {
				while (l < r && pivot <= arr[r]) {
					r -= 1;
				}
				arr[l] = arr[r];
				while (l < r && pivot >= arr[l]) {
					l++;
				}
				arr[r] = arr[l];
			}
			if (l == r) {
				arr[l] = pivot;
			}
			quickSort(arr, left, l);
			quickSort(arr, r+1, right);
		}
	}
}
