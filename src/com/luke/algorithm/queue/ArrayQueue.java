package com.luke.algorithm.queue;

public class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public ArrayQueue(int arrMaxSize){
		maxSize = arrMaxSize;
		arr= new int[maxSize];
		front = -1;
		rear = -1;
	}

	public boolean isFull(){
		return rear == maxSize-1;
	}

	public boolean isEmpty(){
		return rear == front;
	}

	public void addQueue(int n){
		if(isFull()){
			System.out.println("full");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	public int getQueue(){
		if(isEmpty()){
			System.out.println("empty");
			throw new RuntimeException("Queue is Empty");
		}

		front++;
		return arr[front];
	}

	public void showQueue(){
		if(isEmpty()){
			System.out.println("队列为空");
		}

		for(int i=0; i<arr.length; i++){
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	public int peakQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空， 没有数据");
		}
		return arr[front+1];
	}
}
