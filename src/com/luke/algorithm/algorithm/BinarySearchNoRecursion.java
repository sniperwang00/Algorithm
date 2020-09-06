package com.luke.algorithm.algorithm;

public class BinarySearchNoRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 4;
        System.out.printf("target %d 的下标是 %d", target, binarySearch(arr, target));
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
