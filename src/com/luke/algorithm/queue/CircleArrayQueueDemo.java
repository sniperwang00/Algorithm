package com.luke.algorithm.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		CircleArrayQueue queue = new CircleArrayQueue(4);
		Scanner scanner = new Scanner(System.in);

		boolean loop = true;
		char key = ' ';

		while (loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出队列");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列获取数据");
			System.out.println("h(head): 查看队列头部数据");

			key = scanner.next().charAt(0);
			switch (key){
				case 's':
					queue.showQueue();
					break;
				case 'a':
					System.out.println("输入一个数:");
					int val = scanner.nextInt();
					queue.add(val);
					break;
				case 'g':
					System.out.printf("取出的数是%d\n", queue.get());
					break;
				case 'e':
					loop = false;
					System.out.println("程序退出~");
					break;
			}
		}
	}
}

class CircleArrayQueue{

	private int front = 0;
	private int rear = 1;
	private int maxSize;
	private int[] arr;

	public CircleArrayQueue(int size){
		maxSize = size;
		arr= new int[maxSize];
	}

	public void add(int num){
		if(isFull()){
//			throw new RuntimeException("队列已满");
			System.out.println("队列已满");
			return;
		}
		arr[(rear-1)%maxSize] = num;
		rear++;
		System.out.printf("rear=%d", rear);
}

	public int get(){
		if(isEmpty()){
			System.out.println("队列已满");
			throw new RuntimeException("队列为空");
		}
		int result = arr[front%maxSize];
		front++;
		return result;
	}

	public void showQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列为空");
		}

		for(int i=(front%maxSize); i<(((rear-1)-front) + front%maxSize); i++){
			System.out.printf("arr[%d]=%d\n", i, arr[i%maxSize]);
		}
	}

	public boolean isFull(){
		if((rear-1!=front)&&(rear-1-front)%maxSize==0){
			return true;
		}else{
			return false;
		}
	}

	public boolean isEmpty(){
		if ((rear-1) == front) {
			return true;
		}else{
			return false;
		}
	}
}
