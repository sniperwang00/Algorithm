package com.luke.algorithm.tree;

public class ArrayBinaryTreeDemo {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};

		postSort(arr, 0);
	}

	public static void preSort(int[] arr, int n) {
		System.out.println(arr[n]);

		if ((2 * n + 1) < arr.length) {
			preSort(arr, 2*n+1);
		}
		if ((2 * n + 2) < arr.length) {
			preSort(arr, 2 * n + 2);
		}
	}

	public static void infixSort(int[] arr, int n) {
		if ((2 * n + 1) < arr.length) {
			infixSort(arr, 2*n+1);
		}

		System.out.println(arr[n]);

		if ((2 * n + 2) < arr.length) {
			infixSort(arr, 2 * n + 2);
		}
	}

	public static void postSort(int[] arr, int n) {
		if ((2 * n + 1) < arr.length) {
			postSort(arr, 2*n+1);
		}

		if ((2 * n + 2) < arr.length) {
			postSort(arr, 2 * n + 2);
		}

		System.out.println(arr[n]);
	}
}
