package main;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
//		char plus = '+';
//		char minus = '-';
//		char times = '*';
//		char divide = '/';
//		char equal = '=';
//
//		int i = 43;
////		System.out.println((int) plus);
////		System.out.println((int) minus);
////		System.out.println((int) times);
////		System.out.println((int) divide);
////		System.out.println((int) equal);
//		System.out.println(7+5*2-8/4+6+1-3);
//
//		ArrayList arrayList = new ArrayList();

		int temp = -1;
		temp |= 256;
		String str = Integer.toBinaryString(temp);
		System.out.println(str.substring(str.length()-8));
	}
}
