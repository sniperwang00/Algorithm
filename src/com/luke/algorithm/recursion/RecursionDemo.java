package com.luke.algorithm.recursion;

public class RecursionDemo {
	public static void main(String[] args) {
		test(5);
	}

	public static void test(int n){
		if (n > 2) {
			test(n - 1);
		}else{
			System.out.println("n=" + n);
		}
	}
}
