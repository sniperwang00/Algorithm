package com.luke.algorithm.sorting;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random() * 1000);
		}
		System.out.println(Arrays.toString(arr));
		radixSort(arr);
	}

	public static void radixSort(int[] arr) {
		//第一步找到最大的值
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		//循环的次数=最大数的位数
		int maxLength = (max+"").length();
		int[][] bucket = new int[10][arr.length];
		int[] counts = new int[10];
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			for (int j = 0; j < arr.length; j++) {
				//计算余数
				int ys = arr[j] /n % 10;
				bucket[ys][counts[ys]] = arr[j];
				counts[ys]++;
			}
			//从桶里复原到数组中
			int arrPointer = 0;
			for (int x = 0; x < 10; x++) {
				for (int j = 0; j < counts[x]; j++) {
					arr[arrPointer] = bucket[x][j];
					arrPointer++;
				}
				counts[x]=0;
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
