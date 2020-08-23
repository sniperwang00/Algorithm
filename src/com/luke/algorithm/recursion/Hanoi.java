package com.luke.algorithm.recursion;

import java.util.Stack;

public class Hanoi {
	public static void main(String[] args) {
		hanoi(3, 'A', 'B', 'C');

//		Stack<Integer> from = new Stack<>();
//		Stack<Integer> in = new Stack<>();
//		Stack<Integer> to = new Stack<>();
//
//		from.push(3);
//		from.push(2);
//		from.push(1);
//		hanoiStack(3, from, in, to);
//
//		if(to.size()==3){
//			while(to.size()>0){
//				System.out.println("to == > [" + to.pop() + "]");
//			}
//		}
	}

	public static void hanoi(int n, char from, char in, char to) {
		if (n == 1) {
			System.out.println("移动第" + n + "个盘子从" + from + "到" + to);
		}else{
			hanoi(n-1, from, to, in); //把上面n-1个盘子看成一个盘子， 一起移动到中间
			System.out.println("移动第" + n + "个盘子从" + from + "到" + to);
			hanoi(n-1, in, from, to);//把上面n-1个盘子看成一个盘子， 一起移动到右边。。。。
		}
	}

	public static void hanoiStack(int n, Stack<Integer> from, Stack<Integer> in, Stack<Integer> to) {
		if (n == 1) {
//			System.out.println("移动第" + n + "个盘子从" + from + "到" + to);
			to.push(from.pop());
		}else{
			hanoiStack(n-1, from, to, in);
//			System.out.println("移动第" + n + "个盘子从" + from + "到" + to);
			to.push(from.pop());
			hanoiStack(n-1, in, from, to);
		}
	}

}
