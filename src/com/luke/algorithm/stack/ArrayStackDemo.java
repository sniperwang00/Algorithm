package com.luke.algorithm.stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;

		char c = 'a';

//		System.out.println(stack.pop());
		stack.push(c);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(10000);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
}

class ArrayStack{
	int top = -1;
	int max;
	int[] array;

	ArrayStack(int max){
		this.max = max;
		array = new int[max];
	}

	public boolean isEmpty(){
		if(top==-1){
			System.out.println("empty");
			return true;
		}
		return false;
	}

	public boolean isFull(){
		if(top == max-1){
			System.out.println("full");
			return true;
		}
		return false;
	}

	public void push(int i){
		if(isFull()){
			System.out.println("full, can't push");
			return;
		}
		top++;
		array[top] = i;
	}

	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("empty, can't pop");
		}
		int result = array[top];
		top--;
		return result;
	}
}
