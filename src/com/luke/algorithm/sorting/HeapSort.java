package com.luke.algorithm.sorting;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = {9, 6, 8, 7, 0, 1, 10, 4, 2};
		heapSort(arr, arr.length);
//		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void heapSort(int[] arr) {
		int start = (arr.length - 1) / 2;
		for (int i = start; i >= 0; i--) {
			maxHeap(arr, arr.length, i);
		}
		for (int size = arr.length - 1; size > 0; size--) {
			int temp = arr[size];
			arr[size] = arr[0];
			arr[0] = temp;
			maxHeap(arr, size, 0); //第一次交换最小数之后， index=0下面的子树都已经是大顶堆， 只需要从index=0处开始调整其全部子树
		}
	}

	public static void heapSort(int[] arr, int size) {
		int start = (size - 1) / 2;
		for (int i = start; i >= 0; i--) {
			maxHeap(arr, size, i);
		}
		int temp = arr[size-1];
		arr[size-1] = arr[0];
		arr[0] = temp;
		if (size > 1) {
			heapSort(arr, size-1);
		}
	}

	public static void maxHeap(int[] arr, int size, int index) {
		int leftNode = 2 * index + 1;
		int rightNode = 2 * index + 2;

		int max = index;
		//比较index和他的子节点大小
		if (leftNode < size && arr[leftNode] > arr[max]) {
			max = leftNode;
		}
		if (rightNode < size && arr[rightNode] > arr[max]) {
			max = rightNode;
		}
		//进行交换
		if (max != index) {
			int temp = arr[index];
			arr[index] = arr[max];
			arr[max] = temp;
			//交换过后要对节点为max的子树重新进行调整, 并且只有进行交换才需要重新调整， 所以放在里面， 这样递归结束条件也成立了
			maxHeap(arr, size, max);
		}
	}
}
